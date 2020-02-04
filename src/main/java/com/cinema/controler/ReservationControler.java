package com.cinema.controler;

import com.cinema.domain.dto.ReservationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/// @brief Klasa tworząca nową rezerwację.
///
/// Dane składowe
/// ~~~~~~~~~~~~~~~~~~~~~~~~~.java
/// ArrayList<ReservationDto> reservationDtos = new ArrayList<>();  // <- lista przechowująca dane do rezerwacji
/// ~~~~~~~~~~~~~~~~~~~~~~~~~
@Controller
@EnableWebMvc
public class ReservationControler {
    ArrayList<ReservationDto> reservationDtos = new ArrayList<>();

    /// Funkcja dodające rezerwację, tworzy rachunek, bilet, zmienia miejsca rezerwacji w pliku films.json
    /// @param reservationDto - pola niezbędne do stworzenia nowej rezerwacji
    @CrossOrigin
    @RequestMapping(value = "/reservation",method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDto reservationDto) throws IOException, DocumentException {
        Document document = new Document();
        Document bill = new Document();

        reservationDtos.add(reservationDto);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/json/reservations.json"),reservationDtos);

        PdfWriter writerBill = PdfWriter.getInstance(bill,new FileOutputStream("./src/main/webapp/WEB-INF/bills/"+reservationDto.getName()+"B.pdf"));
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("./src/main/webapp/WEB-INF/downloads/"+reservationDto.getName()+"H.pdf"));

        int cena = (10*reservationDto.getStandardSeats().size())+(25*reservationDto.getVipSeats().size());

        //BillGenerator
        bill.open();
        bill.add(new Paragraph("Cena: "+cena));
        bill.add(new Paragraph("Ilość miejsc standard: "+reservationDto.getStandardSeats().size()));
        bill.add(new Paragraph("Ilość miejsc VIP: "+reservationDto.getVipSeats().size()));
        bill.close();
        writerBill.close();

        //TicketGenerator
        document.open();
        document.add(new Paragraph("Imie: "+reservationDto.getName()));
        document.add(new Paragraph("Nazwisko: "+reservationDto.getSurname()));
        document.add(new Paragraph("Miejsca/e: "+reservationDto.getStandardSeats()+" Vip: "+reservationDto.getVipSeats()));
        document.add(new Paragraph("Film: "+reservationDto.getId()));
        document.add(new Paragraph("Godzina: "+reservationDto.getTime()));
        document.close();
        writer.close();

        try (Reader reader = new FileReader("./src/main/resources/json/films.json")) {

            JSONObject object = (JSONObject) new JSONParser().parse(reader);
            JSONArray films = (JSONArray) object.get("films");
            JSONObject filmss = (JSONObject) films.get(reservationDto.getId());
            JSONArray filmsID = (JSONArray) filmss.get("showing");
            JSONObject filmsss = (JSONObject) filmsID.get(timeMovie(reservationDto.getTime()));
            JSONArray filmsss1 = (JSONArray) filmsss.get("blocked");
            System.out.println(filmsss1);

            //Zmiana wartosci w pliku films.json
            filmsss1.addAll(reservationDto.getStandardSeats());
            filmsss1.addAll(reservationDto.getVipSeats());
            System.out.print(filmsss1);

            //JSONObject data = (JSONObject) parser.parse(reader);
            //Nadpisywanie
            @SuppressWarnings("resource")
            FileWriter file = new FileWriter("./src/main/resources/json/films.json");
            file.write(object.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /// @return zwraca wartość int w zależnośći od godziny wyświetlania filmu
    public int timeMovie(String time){
        if (time.equals("12:00")){
            return 0;
        }else if(time.equals("18:00")){
            return 1;
        }else if(time.equals("21:00")){
            return 2;
        }
        return 3;
    }
}

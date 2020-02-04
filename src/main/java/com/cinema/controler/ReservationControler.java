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

@Controller
@EnableWebMvc
public class ReservationControler {
    ArrayList<ReservationDto> reservationDtos = new ArrayList<>();

    @CrossOrigin
    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDto reservationDto) throws IOException, DocumentException {
        Document document = new Document();

        reservationDtos.add(reservationDto);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/json/reservations.json"),reservationDtos);

        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("./src/main/webapp/WEB-INF/downloads/"+reservationDto.getName()+"H.pdf"));
        document.open();
        document.add(new Paragraph("Imie: "+reservationDto.getName()));
        document.add(new Paragraph("Nazwisko: "+reservationDto.getSurname()));
        document.add(new Paragraph("Miejsca/e: "+reservationDto.getStandardSeats()+" Vip: "+reservationDto.getVipSeats()));
        document.add(new Paragraph("Film: "+reservationDto.getId()));
        document.add(new Paragraph("Godzina: "+reservationDto.getTime()));
        document.close();
        writer.close();

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("./src/main/resources/json/films.json")) {

            JSONObject object = (JSONObject) new JSONParser().parse(reader);
            JSONArray films = (JSONArray) object.get("films");
            JSONObject filmss = (JSONObject) films.get(0);
            JSONArray filmsID = (JSONArray) filmss.get("showing");
            JSONObject filmsss = (JSONObject) filmsID.get(0);
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
}

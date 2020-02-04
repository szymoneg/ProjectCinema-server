package com.cinema.controler;

import com.cinema.domain.dto.ReservationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Controller
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

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

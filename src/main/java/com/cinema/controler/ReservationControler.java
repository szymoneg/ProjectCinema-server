package com.cinema.controler;

import com.cinema.domain.dto.ReservationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ReservationControler {
    ArrayList<ReservationDto> reservationDtos = new ArrayList<>();
    ArrayList<Integer> close_seat = new ArrayList<>();

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDto reservationDto) throws IOException {
        reservationDtos.add(reservationDto);
        close_seat.add(reservationDto.getSeat());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/json/reservations.json"),reservationDtos);

        // vv Tylko dla testów
        for (Integer num : close_seat) {
            System.out.println(num);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
package com.cinema.rest;

import com.cinema.domain.dto.CinemaDto;
import com.cinema.domain.dto.CinemaDtoReply;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping(value = "/api")
public class CinemaAPIControler {

    ArrayList<CinemaDto> arr = new ArrayList<>();
    //Gson gson = new Gson();
    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaAPIControler.class);
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public CinemaDtoReply testCinema(@RequestBody CinemaDto cinemaDto) throws IOException {
        arr.add(cinemaDto);
        CinemaDtoReply cinemaDtoReply = new CinemaDtoReply();
        cinemaDtoReply.setId_movie(cinemaDto.getId_movie());
        cinemaDtoReply.setId(cinemaDto.getId());
        cinemaDtoReply.setId_room(cinemaDto.getId_room());
        cinemaDtoReply.setId_seat(cinemaDto.getId_seat());

        objectMapper.writeValue(new File("reservation.json"),arr);
        return cinemaDtoReply;
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<CinemaDto> showCinema() throws IOException, ParseException {
        System.out.println("###Pierwszy krok###");
        org.json.simple.parser.JSONParser parser = new JSONParser();
        org.json.simple.JSONArray a = (JSONArray) parser.parse(new FileReader("movies.json"));
        return a;
    }
}

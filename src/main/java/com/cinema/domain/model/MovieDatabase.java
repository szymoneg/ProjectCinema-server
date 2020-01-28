package com.cinema.domain.model;

import com.cinema.controler.MovieControler;
import com.cinema.domain.dto.MovieDto;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
public class MovieDatabase {

    ArrayList<MovieDto> movieList = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDatabase.class);

    @PostConstruct
    public ArrayList init(){
        LOGGER.info("TEST");
        MovieDto movie1 = new MovieDto(0,"Incepcja","30-03-2021","16:00");
        MovieDto movie2 = new MovieDto(1,"Zjawa","21-01-2020","7:00");

        movieList.add(movie1);
        movieList.add(movie2);

        return movieList;
    }
}

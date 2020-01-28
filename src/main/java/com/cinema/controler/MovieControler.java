package com.cinema.controler;

import com.cinema.domain.model.MovieDatabase;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieControler.class);

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ResponseEntity<String> showMovie(){
        LOGGER.info("Działa metoda show");

        String json = new Gson().toJson(new MovieDatabase().init());
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}

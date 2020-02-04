package com.cinema.controler;

import com.cinema.domain.dto.ConfigDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/// Klasa zwracająca plik JSON z cenami biletów
@Controller
@EnableWebMvc
public class ConfigControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieControler.class);
    @CrossOrigin
    @RequestMapping(value = "/config",method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public ResponseEntity<String> showMovie() {

        final ConfigDto configDto = new ConfigDto();

        return new ResponseEntity<>(configDto.getConfig(), HttpStatus.OK);
    }
}

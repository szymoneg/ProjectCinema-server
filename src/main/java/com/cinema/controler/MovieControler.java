package com.cinema.controler;

import com.cinema.domain.dto.MovieDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/// @brief Klasa odpowiedzialna za zwrócenie JSON "films.json"
/// *EnableWebMvc* - zapewnia działanie serwera w czasie rzeczywistym
@Controller
@EnableWebMvc
public class MovieControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieControler.class);
    @CrossOrigin
    @RequestMapping(value = "/show",method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    /// @return  lista obiektów String z zawartościa filmów
    public ResponseEntity<String> showMovie() {
        LOGGER.info("Działa metoda show");

        final MovieDto movieDto = new MovieDto();

        return new ResponseEntity<>(movieDto.getFilms(), HttpStatus.OK);
    }
}

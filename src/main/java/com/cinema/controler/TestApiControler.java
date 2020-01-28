package com.cinema.controler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestApiControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApiControler.class);
    @CrossOrigin
    @GetMapping(value = "/server-test")
    public ResponseEntity<Map<String, String>> serverTest() {

        LOGGER.info("--- run server status");

        Map<String, String> serverTestMessage = new HashMap<>();
        serverTestMessage.put("server-status", "RUN :-)");

        return new ResponseEntity<>(serverTestMessage, HttpStatus.OK);
    }
}

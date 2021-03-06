package com.cinema.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/// @brief Klasa umożliwia pobieranie biletu z serwera
@RestController
public class TicketControler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketControler.class);

    /// @brief Klasa umożliwia pobieranie biletu z serwera
    @Controller
    @RequestMapping("/download")
    public class DownloadController {
        @Autowired
        ServletContext context;

        /// Funkcja pobierająca bilet z serwera
        /// @param request - link za pomocą którego odbywa się mapowanie
        /// @param response - pobiera dane z biletu
        /// @param fileName - nazwa pliku
        @RequestMapping("/pdf/{fileName:.+}")
        public void downloader(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable("fileName") String fileName) {

            System.out.println("Downloading file :- " + fileName);

            String downloadFolder = context.getRealPath("/WEB-INF/downloads/");
            Path file = Paths.get(downloadFolder, fileName);
            // Check if file exists
            if (Files.exists(file)) {
                // set content type
                response.setContentType("application/pdf");
                // add response header
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                try {
                    // copies all bytes from a file to an output stream
                    Files.copy(file, response.getOutputStream());
                    // flushes output stream
                    response.getOutputStream().flush();
                } catch (IOException e) {
                    System.out.println("Error :- " + e.getMessage());
                }
            } else {
                System.out.println("Sorry File not found!!!!");
            }
        }
    }




}

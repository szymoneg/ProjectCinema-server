package com.cinema.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *   Klasa odpowiedzialna za mozliwość pobrania paragonu z serwera
 *
 */

@RestController
public class BillControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketControler.class);

    //Kod jakiegoś ziomeczka z stacka
    @Controller
    @RequestMapping("/download")
    public class DownloadController {
        @Autowired
        ServletContext context;

        @RequestMapping("/bill/{fileName:.+}")
        public void downloader(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable("fileName") String fileName) {

            System.out.println("Downloading file :- " + fileName);

            String downloadFolder = context.getRealPath("/WEB-INF/bills/");
            Path file = Paths.get(downloadFolder, fileName);
            // Check if file exists
            if (Files.exists(file)) {
                // set content type
                response.setContentType("application/bill");
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

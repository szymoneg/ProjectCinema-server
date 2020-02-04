package com.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/// Klasa główna uruchamiająca serwer
@SpringBootApplication
public class CinemaServerApplication {

	/// Funkcja main inicializująca działanie serwera
	public static void main(String[] args) {
		SpringApplication.run(CinemaServerApplication.class, args);
	}

}

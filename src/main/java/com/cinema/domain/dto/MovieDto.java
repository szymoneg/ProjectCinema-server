package com.cinema.domain.dto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/// @brief Klasa która ma na celu odczytanie pliku JSON
///
/// Dane składowe:
/// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.java
/// private String jsonString = null;
/// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/// *jsonString* - zapisany JSON jako String
public class MovieDto {
    private String jsonString = null;

    /// Konstruktor klasy **MovieDto**.
    public MovieDto(){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/main/resources/json/films.json"));
            JSONObject jsonObject = (JSONObject) obj;
            jsonString = jsonObject.toJSONString();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

    /// @return Zwraca obiekt String jako repertuar filmów jako plik JSON
    public String getFilms() {
        return jsonString;
    }

}

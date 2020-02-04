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
public class ConfigDto {
    private String jsonString = null;

    /// Konstruktor klasy **ConfigDto**.
    public ConfigDto(){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/main/resources/json/config.json"));
            JSONObject jsonObject = (JSONObject) obj;
            jsonString = jsonObject.toJSONString();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

    /// Funkcja zwracająca treść pliku JSON
    /// @return obiekt typu String z treścią pliku JSON
    public String getConfig() {
        return jsonString;
    }

}

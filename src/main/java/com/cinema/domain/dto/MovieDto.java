package com.cinema.domain.dto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MovieDto {
    private String jsonString = null;

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

    public String getFilms() {
        return jsonString;
    }

}

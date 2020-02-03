package com.cinema.domain.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReservationDto {
    private int id;
    private int price;
    private ArrayList<String> standardSeats;
    private ArrayList<String> vipSeats;
    private String name;
    private String surname;
    private String email;
    private String time;

    public ReservationDto() {
    }

    public ReservationDto(int id, int price, ArrayList<String> standardSeats, ArrayList<String> vipSeats, String name, String surname, String email,String time) {
        this.id = id;
        this.price = price;
        this.standardSeats = standardSeats;
        this.vipSeats = vipSeats;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getStandardSeats() {
        return standardSeats;
    }

    public void setStandardSeats(ArrayList<String> standardSeats) {
        this.standardSeats = standardSeats;
    }

    public ArrayList<String> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(ArrayList<String> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.cinema.domain.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;

/// Klasa przechowująca dane użytkowników dokonujących rezerwacje
///
/// ~~~~~~~~~~~~~~~~~~~~~~~~~~.java
/// private int id;
/// private int price;
/// private ArrayList<String> standardSeats;
/// private ArrayList<String> vipSeats;
/// private String name;
/// private String surname;
/// private String email;
/// private String time;
/// ~~~~~~~~~~~~~~~~~~~~~~~~~~
/// *id* - unikalny identyfikator filmu
/// *price* - cena łączna całego zamówienia
/// *standardSeats* - lista miejsc typu standard
/// *vipSeats* - lista miejsc typu VIP
/// *name* - imię użytkownika
/// *surname* - nazwisko użytkownika
/// *email* - email użytkownika
/// *time* - godzina emisi filmu
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

    /// @return unikalny identyfikator filmu
    public int getId() {
        return id;
    }

    /// Funkcja zmieniająca identyfikator użytkownika
    /// @param id - nowy identyfikator
    public void setId(int id) {
        this.id = id;
    }

    /// @return cenę biletu
    public int getPrice() {
        return price;
    }

    /// Funkcja zmieniająca cenę biletu
    /// @param price - nowa cena biletu
    public void setPrice(int price) {
        this.price = price;
    }

    /// @return listę miejsc standardowych
    public ArrayList<String> getStandardSeats() {
        return standardSeats;
    }

    /// Funkcja zmieniająca tablice zarezerwowanych miejsc standardowych
    /// @param standardSeats - nowa lista zarezerwowanych miejsc standardowych
    public void setStandardSeats(ArrayList<String> standardSeats) {
        this.standardSeats = standardSeats;
    }

    /// @return listę miejsc VIP
    public ArrayList<String> getVipSeats() {
        return vipSeats;
    }

    /// Funkcja zmieniająca tablice zarezerwowanych miejsc vip
    /// @param vipSeats - nowa lista zarezerwowanych miejsc vip
    public void setVipSeats(ArrayList<String> vipSeats) {
        this.vipSeats = vipSeats;
    }

    /// @return imię użytkownika
    public String getName() {
        return name;
    }

    /// Funkcja zmieniająca imię użytkownia
    /// @param name - nowe imię użytkownika
    public void setName(String name) { this.name = name; }

    /// @return nazwisko użytkownika
    public String getSurname() {
        return surname;
    }

    /// Funkcja zmieniająca nazwisko użytkownia
    /// @param surname - nowe nazwisko użytkownika
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /// @return email użytkownika
    public String getEmail() {
        return email;
    }

    /// Funkcja zmieniająca email użytkownia
    /// @param email - nowy email użytkownika
    public void setEmail(String email) {
        this.email = email;
    }

    /// @return godzina filmu
    public String getTime() {
        return time;
    }

    /// Funkcja zmieniająca czas wyświetlanego filmu
    /// @param time - nowy czas wyświetlania filmu
    public void setTime(String time) {
        this.time = time;
    }
}

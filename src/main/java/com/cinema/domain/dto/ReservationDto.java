package com.cinema.domain.dto;

public class ReservationDto {
    private int id;
    private String name;
    private String lastname;
    private int seat;
    private String value;
    private int id_movie;

    public ReservationDto() {
    }

    public ReservationDto(int id, String name, String lastname, int seat, String value, int id_movie) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.seat = seat;
        this.value = value;
        this.id_movie = id_movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }
}

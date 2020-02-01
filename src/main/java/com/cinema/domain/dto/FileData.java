package com.cinema.domain.dto;

public class FileData {
    private String name;
    private String lastName;
    private String seat;
    private String type;
    private String movie;

    public FileData(String name, String lastName, String seat, String type, String movie) {
        this.name = name;
        this.lastName = lastName;
        this.seat = seat;
        this.type = type;
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}

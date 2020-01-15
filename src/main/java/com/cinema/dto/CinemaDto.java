package com.cinema.domain.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public class CinemaDto {
    private long id;
    private long id_room;
    private long id_seat;
    private long id_movie;
    private String name;
    private String lastname;
    private String email;

    public CinemaDto() {
    }

    public CinemaDto(long id, long id_room, long id_seat, long id_movie, String name, String lastname, String email) {
        this.id = id;
        this.id_room = id_room;
        this.id_seat = id_seat;
        this.id_movie = id_movie;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_room() {
        return id_room;
    }

    public void setId_room(long id_room) {
        this.id_room = id_room;
    }

    public long getId_seat() {
        return id_seat;
    }

    public void setId_seat(long id_seat) {
        this.id_seat = id_seat;
    }

    public long getId_movie() {
        return id_movie;
    }

    public void setId_movie(long id_movie) {
        this.id_movie = id_movie;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.cinema.domain.dto;

import java.time.ZonedDateTime;

public class CinemaDtoReply {
    private long id;
    private long id_room;
    private long id_movie;
    private long id_seat;

    public long getId_seat() {
        return id_seat;
    }

    public void setId_seat(long id_seat) {
        this.id_seat = id_seat;
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

    public long getId_movie() {
        return id_movie;
    }

    public void setId_movie(long id_movie) {
        this.id_movie = id_movie;
    }
}

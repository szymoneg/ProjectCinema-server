package com.cinema.domain.dto;

public class MovieDto {
    private int id;
    private String title;
    private String data;
    private String show;

    public MovieDto() {
    }

    public MovieDto(int id, String title, String data, String show) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.show = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}

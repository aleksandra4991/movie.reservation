package com.cinema.movie.reservation.dto;

public class FilmGenreRequest {

    private String name;

    public FilmGenreRequest() {
    }

    public FilmGenreRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

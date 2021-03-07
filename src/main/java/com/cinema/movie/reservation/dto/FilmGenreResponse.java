package com.cinema.movie.reservation.dto;

public class FilmGenreResponse {

    private Long filmGenreId;
    private String name;

    public FilmGenreResponse() {
    }

    public FilmGenreResponse(Long filmGenreId, String name) {
        this.filmGenreId = filmGenreId;
        this.name = name;
    }

    public Long getFilmGenreId() {
        return filmGenreId;
    }

    public void setFilmGenreId(Long filmGenreId) {
        this.filmGenreId = filmGenreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

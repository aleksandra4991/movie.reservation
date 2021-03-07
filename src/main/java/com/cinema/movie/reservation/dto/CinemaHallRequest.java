package com.cinema.movie.reservation.dto;

public class CinemaHallRequest {

    private String name;
    private Long cinemaId;

    public CinemaHallRequest() {
    }

    public CinemaHallRequest(String name, Long cinemaId) {
        this.name = name;
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }
}

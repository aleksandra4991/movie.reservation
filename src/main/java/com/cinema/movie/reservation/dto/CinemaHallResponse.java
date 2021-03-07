package com.cinema.movie.reservation.dto;

public class CinemaHallResponse {

    private Long cinemaHallId;
    private String name;
    private Long cinemaId;

    public CinemaHallResponse() {
    }

    public CinemaHallResponse(Long cinemaHallId, String name, Long cinemaId) {
        this.cinemaHallId = cinemaHallId;
        this.name = name;
        this.cinemaId = cinemaId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
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

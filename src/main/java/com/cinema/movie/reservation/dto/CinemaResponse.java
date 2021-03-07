package com.cinema.movie.reservation.dto;

import com.cinema.movie.reservation.domain.Cinema;

public class CinemaResponse {

    private Long cinemaId;
    private String name;
    private Long cityId;

    public CinemaResponse() {
    }

    public CinemaResponse(Cinema cinema) {
    }

    public CinemaResponse(Long cinemaId, String name, Long cityId) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.cityId = cityId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}

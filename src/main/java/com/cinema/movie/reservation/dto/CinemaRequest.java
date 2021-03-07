package com.cinema.movie.reservation.dto;

public class CinemaRequest {

    private String name;
    private Long cityId;

    public CinemaRequest() {
    }

    public CinemaRequest(String name, Long cityId) {
        this.name = name;
        this.cityId = cityId;
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

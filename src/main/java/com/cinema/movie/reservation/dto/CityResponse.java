package com.cinema.movie.reservation.dto;

public class CityResponse {

    private Long cityId;
    private String name;

    public CityResponse() {
    }

    public CityResponse(Long cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

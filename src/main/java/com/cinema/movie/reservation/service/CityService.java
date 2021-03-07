package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.CityRequest;
import com.cinema.movie.reservation.dto.CityResponse;

import java.util.List;

public interface CityService {

    List<CityResponse> getAllCities();
    CityResponse getCityByName(String name);
    void addNewCity (CityRequest cityRequest);

}

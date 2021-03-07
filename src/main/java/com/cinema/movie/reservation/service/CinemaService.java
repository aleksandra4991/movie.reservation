package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.CinemaRequest;
import com.cinema.movie.reservation.dto.CinemaResponse;

import java.util.*;

public interface CinemaService {

    List <CinemaResponse> getAllCinemas();
    List <CinemaResponse> getCinemasFromRequestedCity(Long cityId);
    CinemaResponse getCinemaByName(String name);
    void addNewCinema (CinemaRequest cinemaRequest);

}

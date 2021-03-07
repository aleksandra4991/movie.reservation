package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.CinemaHallRequest;
import com.cinema.movie.reservation.dto.CinemaHallResponse;

import java.util.*;

public interface CinemaHallService {

    List <CinemaHallResponse> getAllCinemaHalls();
    List <CinemaHallResponse> getAllCinemaHallsFromSpecifiedCinema (Long cinemaId);
    List <CinemaHallResponse> getSpecifiedCinemaHallFromSpecifiedCinema (Long cinemaHallId, Long cinemaId);
    void addNewCinemaHall (CinemaHallRequest cinemaHallRequest);
}

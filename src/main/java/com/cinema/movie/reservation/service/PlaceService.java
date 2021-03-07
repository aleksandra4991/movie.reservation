package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.PlaceRequest;
import com.cinema.movie.reservation.dto.PlaceResponse;

import java.util.List;

public interface PlaceService {

    List <PlaceResponse> getAllPlaces();
    List <PlaceResponse> getAllPlacesFromSpecifiedCinemaHall (Long cinemaHallId);
    List <PlaceResponse> getSpecifiedPlaceFromSpecifiedCinemaHall (Long placeId, boolean reserved, Long cinemaHallId);
    List <PlaceResponse> getSpecifiedReservedPlaceFromSpecifiedCinemaHall (Long placeId, boolean reserved, Long cinemaHallId);
    void reserveSpecifiedPlace (boolean reserved, Long cinemaTicket);
    void addNewPlace (PlaceRequest newPlaceRequest);
}

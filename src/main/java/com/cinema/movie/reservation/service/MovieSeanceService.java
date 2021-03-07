package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.MovieSeanceRequest;
import com.cinema.movie.reservation.dto.MovieSeanceResponse;

import java.util.List;

public interface MovieSeanceService {

    List <MovieSeanceResponse> getAllMovieSeances();
    MovieSeanceResponse getMovieSeanceByMovieSeanceId(Long movieSeanceId);
    List <MovieSeanceResponse> getMovieSeancesOfSpecifiedMovie(Long movieId);
    List <MovieSeanceResponse> getMovieSeancesInSpecifiedCinemaHall(Long cinemaHallId);
    List <MovieSeanceResponse> getMovieSeancesOfSpecifiedMovieInSpecifiedCinemaHall(Long movieId, Long cinemaHallId);
    void addNewMovieSeance (MovieSeanceRequest newMovieSeanceRequest);

}

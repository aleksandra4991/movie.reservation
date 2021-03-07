package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.FilmGenreRequest;
import com.cinema.movie.reservation.dto.FilmGenreResponse;

import java.util.List;
public interface FilmGenreService {

    List <FilmGenreResponse> getAllFilmGenres();
    FilmGenreResponse getFilmGenreByFilmGenreName(String name);
    void addNewFilmGenre (FilmGenreRequest filmGenreRequest);

}

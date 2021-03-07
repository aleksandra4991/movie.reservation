package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.dto.MovieRequest;
import com.cinema.movie.reservation.dto.MovieResponse;

import java.util.List;

public interface MovieService {

    List<MovieResponse> getAllMovies();
    MovieResponse getMovieByTitle(String title);
    List<MovieResponse> getMoviesOfSpecifiedFilmGenre(Long filmGenreId);
    void addNewMovie (MovieRequest newMovieRequest);

}

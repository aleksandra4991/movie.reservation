package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.MovieRequest;
import com.cinema.movie.reservation.dto.MovieResponse;
import com.cinema.movie.reservation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/cinema/movies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedMovie")
    public ResponseEntity<MovieResponse> getSpecifiedMovie(@RequestParam String title) {
        return new ResponseEntity<MovieResponse>(movieService.getMovieByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedFilmGenre/movies")
    public ResponseEntity<List<MovieResponse>> getAllMoviesOfSpecifiedFilmGenre(@RequestParam Long filmGenreId) {
        return new ResponseEntity<>(movieService.getMoviesOfSpecifiedFilmGenre(filmGenreId), HttpStatus.OK);
    }

    @PostMapping("/cinema/newMovie")
    public ResponseEntity addNewMovie(@RequestBody MovieRequest movieRequest) {
        movieService.addNewMovie(movieRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

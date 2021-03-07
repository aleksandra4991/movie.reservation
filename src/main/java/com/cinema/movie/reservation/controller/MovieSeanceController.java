package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.MovieSeanceRequest;
import com.cinema.movie.reservation.dto.MovieSeanceResponse;
import com.cinema.movie.reservation.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieSeanceController {

    private final MovieSeanceService movieSeanceService;

    @Autowired
    public MovieSeanceController(MovieSeanceService movieSeanceService) {
        this.movieSeanceService = movieSeanceService;
    }

    @GetMapping("/cinema/moviesSeances")
    public ResponseEntity<List<MovieSeanceResponse>> getAllMovieSeances() {
        return new ResponseEntity<>(movieSeanceService.getAllMovieSeances(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedMovieSeance")
    public ResponseEntity<MovieSeanceResponse> getSpecifiedMovieSeance(@RequestParam Long movieSeanceId) {
        return new ResponseEntity<MovieSeanceResponse>(movieSeanceService.getMovieSeanceByMovieSeanceId(movieSeanceId), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedFilm/movieSeances")
    public ResponseEntity<List<MovieSeanceResponse>> getAllMovieSeancesOfSpecifiedMovie(@RequestParam Long movieId) {
        return new ResponseEntity<>(movieSeanceService.getMovieSeancesOfSpecifiedMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCinemaHall/movieSeances")
    public ResponseEntity<List<MovieSeanceResponse>> getAllMovieSeancesPlayedInSpecifiedCinemaHall(@RequestParam Long cinemaHallId) {
        return new ResponseEntity<>(movieSeanceService.getMovieSeancesInSpecifiedCinemaHall(cinemaHallId), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedFilmAndSpecifiedCinemaHall/movieSeances")
    public ResponseEntity<List<MovieSeanceResponse>> getAllMovieSeancesOfSpecifiedMoviePlayedInSpecifiedCinemaHal(@RequestParam Long movieId, @RequestParam Long cinemaHallId) {
        return new ResponseEntity<>(movieSeanceService.getMovieSeancesOfSpecifiedMovieInSpecifiedCinemaHall(movieId,cinemaHallId), HttpStatus.OK);
    }

    @PostMapping("/cinema/newMovieSeance")
    public ResponseEntity addNewMovieSeance(@RequestBody MovieSeanceRequest movieSeanceRequest) {
        movieSeanceService.addNewMovieSeance(movieSeanceRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

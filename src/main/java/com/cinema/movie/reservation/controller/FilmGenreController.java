package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.FilmGenreRequest;
import com.cinema.movie.reservation.dto.FilmGenreResponse;
import com.cinema.movie.reservation.service.FilmGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class FilmGenreController {

    private final FilmGenreService filmGenreService;

    @Autowired
    public FilmGenreController(FilmGenreService filmGenreService) {
        this.filmGenreService = filmGenreService;
    }

    @GetMapping("/cinema/filmGenres")
    public ResponseEntity<List<FilmGenreResponse>> getAllFilmGenres() {
        return new ResponseEntity<>(filmGenreService.getAllFilmGenres(), HttpStatus.OK);
    }

    @GetMapping("/cinema/SpecifiedFilmGenre")
    public ResponseEntity<FilmGenreResponse> getSpecifiedFilmGenre(@RequestParam String filmGenreName) {
        return new ResponseEntity<FilmGenreResponse>(filmGenreService.getFilmGenreByFilmGenreName(filmGenreName), HttpStatus.OK);
    }

    @PostMapping("/cinema/newFilmGenre")
    public ResponseEntity addNewFilmGenre(@RequestBody FilmGenreRequest filmGenreRequest) {
        filmGenreService.addNewFilmGenre(filmGenreRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

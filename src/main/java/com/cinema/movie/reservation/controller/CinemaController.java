package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.CinemaRequest;
import com.cinema.movie.reservation.dto.CinemaResponse;
import com.cinema.movie.reservation.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinema/cinemas")
    public ResponseEntity<List<CinemaResponse>> getAllCinemas() {
        return new ResponseEntity<>(cinemaService.getAllCinemas(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCinema")
    public ResponseEntity<CinemaResponse> getSpecifiedCinema(@RequestParam String name) {
        return new ResponseEntity<CinemaResponse>(cinemaService.getCinemaByName(name), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCity/cinemas")
    public ResponseEntity<List<CinemaResponse>> getAllCinemasOfSpecifiedCity(@RequestParam Long cityId) {
        return new ResponseEntity<>(cinemaService.getCinemasFromRequestedCity(cityId), HttpStatus.OK);
    }

    @PostMapping("/cinema/newCinema")
    public ResponseEntity addNewCinema(@RequestBody CinemaRequest cinemaRequest) {
        cinemaService.addNewCinema(cinemaRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

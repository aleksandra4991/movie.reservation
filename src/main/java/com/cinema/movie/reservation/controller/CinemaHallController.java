package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.CinemaHallRequest;
import com.cinema.movie.reservation.dto.CinemaHallResponse;
import com.cinema.movie.reservation.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/cinema/cinemaHalls")
    public ResponseEntity<List<CinemaHallResponse>> getAllCinemaHalls() {
        return new ResponseEntity<>(cinemaHallService.getAllCinemaHalls(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCinema/cinemaHalls")
    public ResponseEntity<List<CinemaHallResponse>> getAllCinemaHallsOfSpecifiedCinema(@RequestParam Long cinemaId) {
        return new ResponseEntity<>(cinemaHallService.getAllCinemaHallsFromSpecifiedCinema(cinemaId), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCinema/specifiedCinemaHall")
    public ResponseEntity<List<CinemaHallResponse>> getSpecifiedCinemaHallOfSpecifiedCinema(@RequestParam Long cinemaId, @RequestParam Long cinemaHallId) {
        return new ResponseEntity<>(cinemaHallService.getSpecifiedCinemaHallFromSpecifiedCinema(cinemaId,cinemaHallId), HttpStatus.OK);
    }

    @PostMapping("/cinema/newCinemaHall")
    public ResponseEntity addNewCinemaHall(@RequestBody CinemaHallRequest cinemaHallRequest) {
        cinemaHallService.addNewCinemaHall(cinemaHallRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

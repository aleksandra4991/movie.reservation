package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.PlaceRequest;
import com.cinema.movie.reservation.dto.PlaceResponse;
import com.cinema.movie.reservation.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/cinema/places")
    public ResponseEntity<List<PlaceResponse>> getAllPlaces() {
        return new ResponseEntity<>(placeService.getAllPlaces(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCinemaHall/places")
    public ResponseEntity<List<PlaceResponse>> getAllPlacesFromSpecifiedCinemaHall(@RequestParam Long cinemaHallId) {
        return new ResponseEntity<>(placeService.getAllPlacesFromSpecifiedCinemaHall(cinemaHallId), HttpStatus.OK);
    }

    @PutMapping("/cinema/reserveSpecifiedPlace")
    public ResponseEntity reserveSpecifiedPlace(@RequestParam Boolean reserved, @RequestParam Long cinemaTicketId){
        placeService.reserveSpecifiedPlace(false,cinemaTicketId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/cinema/newPlace")
    public ResponseEntity addNewPlace(@RequestBody PlaceRequest placeRequest) {
        placeService.addNewPlace(placeRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

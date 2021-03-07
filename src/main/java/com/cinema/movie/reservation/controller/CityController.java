package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.dto.CityRequest;
import com.cinema.movie.reservation.dto.CityResponse;
import com.cinema.movie.reservation.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cinema/cities")
    public ResponseEntity<List<CityResponse>> getAllCities() {
        return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK);
    }

    @GetMapping("/cinema/specifiedCity")
    public ResponseEntity<CityResponse> getSpecifiedCity(@RequestParam String name) {
        return new ResponseEntity<CityResponse>(cityService.getCityByName(name), HttpStatus.OK);
    }

    @PostMapping("/cinema/newCity")
    public ResponseEntity addNewCity(@RequestBody CityRequest cityRequest) {
        cityService.addNewCity(cityRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

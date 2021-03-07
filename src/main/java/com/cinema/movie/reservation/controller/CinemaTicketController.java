package com.cinema.movie.reservation.controller;

import com.cinema.movie.reservation.domain.CinemaTicket;
import com.cinema.movie.reservation.dto.CinemaTicketRequest;
import com.cinema.movie.reservation.service.CinemaTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class CinemaTicketController {

    private final CinemaTicketService cinemaTicketService;

    @Autowired
    public CinemaTicketController(CinemaTicketService cinemaTicketService) {
        this.cinemaTicketService = cinemaTicketService;
    }

    @PostMapping("/cinema/buyTicket")
    public ResponseEntity<CinemaTicket> buyTicketForSpecifiedMovieSeance(@RequestBody CinemaTicketRequest cinemaTicketRequest) {
        cinemaTicketService.buyTicketsOnSpecifiedMovieSeance(cinemaTicketRequest);
        return new ResponseEntity<CinemaTicket>(HttpStatus.CREATED);
    }
}

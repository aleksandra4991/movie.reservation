package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.CinemaTicket;
import com.cinema.movie.reservation.dto.CinemaTicketRequest;

public interface CinemaTicketService {

    CinemaTicket buyTicketsOnSpecifiedMovieSeance (CinemaTicketRequest cinemaTicketRequest);
}

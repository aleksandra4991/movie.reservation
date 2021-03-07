package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.CinemaTicket;
import com.cinema.movie.reservation.domain.MovieSeance;
import com.cinema.movie.reservation.domain.Place;
import com.cinema.movie.reservation.dto.CinemaTicketRequest;
import com.cinema.movie.reservation.repository.CinemaTicketRepository;
import com.cinema.movie.reservation.repository.MovieSeanceRepository;
import com.cinema.movie.reservation.repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CinemaTicketServiceImplementation implements CinemaTicketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaTicketServiceImplementation.class);

    private final CinemaTicketRepository cinemaTicketRepository;
    private final MovieSeanceRepository movieSeanceRepository;
    private final PlaceRepository placeRepository;

    public CinemaTicketServiceImplementation(CinemaTicketRepository cinemaTicketRepository, MovieSeanceRepository movieSeanceRepository, PlaceRepository placeRepository) {
        this.cinemaTicketRepository = cinemaTicketRepository;
        this.movieSeanceRepository = movieSeanceRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public CinemaTicket buyTicketsOnSpecifiedMovieSeance(CinemaTicketRequest cinemaTicketRequest) {
        LOGGER.info("Buing Ticket for movieSeance started");
        CinemaTicket boughtCinemaTicket = new CinemaTicket();
        boughtCinemaTicket.setPrice(cinemaTicketRequest.getPrice());
        boughtCinemaTicket.setClientEmail(cinemaTicketRequest.getClientEmail());

        LOGGER.info("Looking for movieSeance with movieSeanceId: " + cinemaTicketRequest.getMovieSeanceId());
        MovieSeance movieSeanceToBuyTicketFor = movieSeanceRepository.getMovieSeanceByMovieSeanceId(cinemaTicketRequest.getMovieSeanceId());
        LOGGER.info("Looking for place with PlaceId: " + cinemaTicketRequest.getPlaceId());
        Place placeToBuyTicketFor = placeRepository.findPlaceByPlaceId(cinemaTicketRequest.getPlaceId());
        if(movieSeanceToBuyTicketFor != null && placeToBuyTicketFor != null){
            LOGGER.info("MovieSeance with movieSeanceId: " + cinemaTicketRequest.getMovieSeanceId() + " and place with placeId: " + cinemaTicketRequest.getPlaceId() + " found successfully. Ticket could be bought.");
            boughtCinemaTicket.setMovieSeance(movieSeanceToBuyTicketFor);
            boughtCinemaTicket.setPlace(placeToBuyTicketFor);
            return cinemaTicketRepository.save(boughtCinemaTicket);
        } else{
            LOGGER.info("MovieSeance with movieSeanceId: " + cinemaTicketRequest.getMovieSeanceId() + " and/or place with placeId: " + cinemaTicketRequest.getPlaceId() + " not found successfully Ticket could not be bought.");
        }
        return new CinemaTicket();
    }
}

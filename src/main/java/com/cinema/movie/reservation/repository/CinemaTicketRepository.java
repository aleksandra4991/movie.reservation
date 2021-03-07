package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.CinemaTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaTicketRepository extends CrudRepository <CinemaTicket, Long> {

    CinemaTicket getCinemaTicketByCinemaTicketId (Long cinemaTicketId);
}

package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.CinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends CrudRepository <CinemaHall, Long> {

    CinemaHall getCinemaHallByCinemaHallId (Long cinemaHallId);

}

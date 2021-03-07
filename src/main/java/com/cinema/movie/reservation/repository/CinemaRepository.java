package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.Cinema;
import com.cinema.movie.reservation.domain.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends CrudRepository <Cinema, Long> {

    Cinema getCinemaByCinemaId (Long cinemaId);

    @Query("SELECT c FROM Cinema c WHERE c.name = :name")
    public Cinema getCinemaByName(@Param("name") String name);
}

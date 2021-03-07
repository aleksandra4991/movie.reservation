package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.MovieSeance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSeanceRepository extends CrudRepository <MovieSeance, Long> {

    MovieSeance getMovieSeanceByMovieSeanceId(Long movieSeanceId);


}

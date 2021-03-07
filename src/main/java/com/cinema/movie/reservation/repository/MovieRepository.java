package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.FilmGenre;
import com.cinema.movie.reservation.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository <Movie, Long> {

    Movie getMovieByMovieId (Long movieId);
    List <Movie> findAllByFilmGenre (FilmGenre filmGenre);

    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    public Movie getMovieByTitle(@Param("title") String title);

}

package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.FilmGenre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmGenreRepository extends CrudRepository <FilmGenre, Long> {

    FilmGenre getFilmGenreByFilmGenreId (Long filmGenreId);

    @Query("SELECT f FROM FilmGenre f WHERE f.name = :name")
    public FilmGenre getFilmGenreByName(@Param("name") String name);
}

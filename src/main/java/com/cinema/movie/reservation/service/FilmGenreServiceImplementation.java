package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.FilmGenre;
import com.cinema.movie.reservation.dto.FilmGenreRequest;
import com.cinema.movie.reservation.dto.FilmGenreResponse;
import com.cinema.movie.reservation.repository.FilmGenreRepository;
import com.cinema.movie.reservation.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FilmGenreServiceImplementation implements FilmGenreService{

    private static final Logger LOGGER = LoggerFactory.getLogger(FilmGenreServiceImplementation.class);

    private final FilmGenreRepository filmGenreRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public FilmGenreServiceImplementation(FilmGenreRepository filmGenreRepository, MovieRepository movieRepository) {
        this.filmGenreRepository = filmGenreRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<FilmGenreResponse> getAllFilmGenres() {
        LOGGER.info("Getting all filmGenres from repository started");
        return StreamSupport.stream(filmGenreRepository.findAll().spliterator(),false)
                .map(filmGenre -> new FilmGenreResponse(filmGenre.getFilmGenreId(),filmGenre.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public FilmGenreResponse getFilmGenreByFilmGenreName(String name) {
        LOGGER.info("Getting filmGenre with filmGenreName: " + name + " from repository started");
        FilmGenre foundFilmGenre = filmGenreRepository.getFilmGenreByName(name);
        if(foundFilmGenre != null){
        LOGGER.info("FilmGenre with filmGenreName " + name + " successfully found in repository.");
        FilmGenreResponse filmGenreResponse = new FilmGenreResponse();
        filmGenreResponse.setFilmGenreId(foundFilmGenre.getFilmGenreId());
        filmGenreResponse.setName(foundFilmGenre.getName());
        return filmGenreResponse;
    } else {
            LOGGER.warn("No filmGenre with filmGenreName: " + name + " found in repository");
            return new FilmGenreResponse();
        }
    }

    @Override
    public void addNewFilmGenre(FilmGenreRequest filmGenreRequest) {
        LOGGER.info("Adding new filmeGenre, name: " + filmGenreRequest.getName() + " started.");
        FilmGenre newFilmGenre = new FilmGenre();
        newFilmGenre.setName(filmGenreRequest.getName());
        FilmGenre savedFilmGenre = filmGenreRepository.save(newFilmGenre);
        if(filmGenreRepository.getFilmGenreByFilmGenreId(savedFilmGenre.getFilmGenreId()) != null){
            LOGGER.info("New filmGenre,name: " + savedFilmGenre.getName() + " added successfully");
        } else {
            LOGGER.error("New filmGenre,name: " + savedFilmGenre.getName() + " not added successfully");
        }
    }

}

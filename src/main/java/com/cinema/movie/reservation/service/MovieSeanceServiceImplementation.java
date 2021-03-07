package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.MovieSeance;
import com.cinema.movie.reservation.dto.MovieSeanceRequest;
import com.cinema.movie.reservation.dto.MovieSeanceResponse;
import com.cinema.movie.reservation.repository.CinemaHallRepository;
import com.cinema.movie.reservation.repository.MovieRepository;
import com.cinema.movie.reservation.repository.MovieSeanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieSeanceServiceImplementation implements MovieSeanceService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieSeanceServiceImplementation.class);

    private final MovieSeanceRepository movieSeanceRepository;
    private final MovieRepository movieRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public MovieSeanceServiceImplementation(MovieSeanceRepository movieSeanceRepository, MovieRepository movieRepository, CinemaHallRepository cinemaHallRepository) {
        this.movieSeanceRepository = movieSeanceRepository;
        this.movieRepository = movieRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public List<MovieSeanceResponse> getAllMovieSeances() {
        LOGGER.info("Getting all moviesSeances from repository started");
        return StreamSupport.stream(movieSeanceRepository.findAll().spliterator(),false)
                .map(movieSeance -> new MovieSeanceResponse(movieSeance.getMovieSeanceId(),movieSeance.getProjectionDate(),movieSeance.getMovie().getMovieId(),movieSeance.getMovie().getTitle(),movieSeance.getCinemaHall().getCinemaHallId()))
                .collect(Collectors.toList());
    }

    @Override
    public MovieSeanceResponse getMovieSeanceByMovieSeanceId(Long movieSeanceId) {
        LOGGER.info("Getting movieSeance with movieSeanceId: " + movieSeanceId + " from repository started");
        MovieSeance foundMovieSeance = movieSeanceRepository.getMovieSeanceByMovieSeanceId(movieSeanceId);
        if(foundMovieSeance != null){
            LOGGER.info("MovieSeance with movieSeanceId " + movieSeanceId + " successfully found in repository.");
            MovieSeanceResponse movieSeanceResponse = new MovieSeanceResponse();
            movieSeanceResponse.setCinemaHallId(foundMovieSeance.getCinemaHall().getCinemaHallId());
            movieSeanceResponse.setProjectionDate(foundMovieSeance.getProjectionDate());
            return movieSeanceResponse;
        } else {
            LOGGER.warn("No movieSeance with movieSeanceId: " + movieSeanceId + " found in repository");
            return new MovieSeanceResponse();
        }
    }

    @Override
    public List<MovieSeanceResponse> getMovieSeancesOfSpecifiedMovie(Long movieId) {
        LOGGER.info("Getting moviesSeances of movie with movieId: " + movieId + " from repository started");
        return StreamSupport.stream(movieSeanceRepository.findAll().spliterator(),false)
                .map(movieSeance -> new MovieSeanceResponse(movieSeance.getMovieSeanceId(),movieSeance.getProjectionDate(),movieSeance.getMovie().getMovieId(),movieSeance.getMovie().getTitle(),movieSeance.getCinemaHall().getCinemaHallId()))
                .filter(movieSeanceResponse -> movieSeanceResponse.getMovieId() == movieId)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieSeanceResponse> getMovieSeancesInSpecifiedCinemaHall(Long cinemaHallId) {
        LOGGER.info("Getting moviesSeances playes in specified cinemaHall with cinemaHallId: " + cinemaHallId + " from repository started");
        return StreamSupport.stream(movieSeanceRepository.findAll().spliterator(),false)
                .map(movieSeance -> new MovieSeanceResponse(movieSeance.getMovieSeanceId(),movieSeance.getProjectionDate(),movieSeance.getMovie().getMovieId(),movieSeance.getMovie().getTitle(),movieSeance.getCinemaHall().getCinemaHallId()))
                .filter(movieSeanceResponse -> movieSeanceResponse.getCinemaHallId() == cinemaHallId)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieSeanceResponse> getMovieSeancesOfSpecifiedMovieInSpecifiedCinemaHall(Long movieId, Long cinemaHallId) {
        LOGGER.info("Getting moviesSeances of movie with movieId: " + movieId + " in cinemaHall with cinemaHallId: "+ cinemaHallId + " from repository started");
        return StreamSupport.stream(movieSeanceRepository.findAll().spliterator(),false)
                .map(movieSeance -> new MovieSeanceResponse(movieSeance.getMovieSeanceId(),movieSeance.getProjectionDate(),movieSeance.getMovie().getMovieId(),movieSeance.getMovie().getTitle(),movieSeance.getCinemaHall().getCinemaHallId()))
                .filter(movieSeanceResponse -> movieSeanceResponse.getMovieId() == movieId)
                .filter(movieSeanceResponse -> movieSeanceResponse.getCinemaHallId() == cinemaHallId)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewMovieSeance(MovieSeanceRequest newMovieSeanceRequest) {
        LOGGER.info("Adding new movieSeance,movie with movieId: " + newMovieSeanceRequest.getMovieId() + ", cinemaHallId: " + newMovieSeanceRequest.getCinemaHallId() + " started.");
        MovieSeance newMovieSeance = new MovieSeance();
        newMovieSeance.setProjectionDate(newMovieSeanceRequest.getProjectionDate());
        if (movieRepository.getMovieByMovieId(newMovieSeanceRequest.getMovieId()) != null && cinemaHallRepository.getCinemaHallByCinemaHallId(newMovieSeanceRequest.getCinemaHallId()) != null){
            newMovieSeance.setMovie(movieRepository.getMovieByMovieId(newMovieSeanceRequest.getMovieId()));
            newMovieSeance.setCinemaHall(cinemaHallRepository.getCinemaHallByCinemaHallId(newMovieSeanceRequest.getCinemaHallId()));
            MovieSeance savedMovieSeance = movieSeanceRepository.save(newMovieSeance);
            if (movieSeanceRepository.getMovieSeanceByMovieSeanceId(savedMovieSeance.getMovieSeanceId()) != null) {
                LOGGER.info("New movieSeance,movieSeanceId: " + savedMovieSeance.getMovieSeanceId() + " added successfully");
            } else {
                LOGGER.error("New movieSeance,movieSeanceId: " + savedMovieSeance.getMovieSeanceId() + " not added successfully");
            }
        }
        else {
            LOGGER.warn("No such movie with movieId: " + newMovieSeanceRequest.getMovieId()
                    + " or cinemaHall with cinemaHallId: " + newMovieSeanceRequest.getCinemaHallId() + "found in repository");
        }
    }


}




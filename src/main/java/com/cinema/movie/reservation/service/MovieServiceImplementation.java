package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.Movie;;
import com.cinema.movie.reservation.dto.MovieRequest;
import com.cinema.movie.reservation.dto.MovieResponse;
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
public class MovieServiceImplementation implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImplementation.class);

    private final MovieRepository movieRepository;
    private final FilmGenreRepository filmGenreRepository;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository, FilmGenreRepository filmGenreRepository) {
        this.movieRepository = movieRepository;
        this.filmGenreRepository = filmGenreRepository;
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        LOGGER.info("Getting all movies from repository started");
        return StreamSupport.stream(movieRepository.findAll().spliterator(),false)
                .map(movie -> new MovieResponse(movie.getMovieId(),movie.getTitle(),movie.getDirector(),movie.getDescription(),movie.getDuration(),movie.getReleaseDate(),movie.getMark(),movie.getImage(),movie.getFilmGenre().getFilmGenreId()))
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieByTitle(String title) {
        LOGGER.info("Getting movie with title: " + title + " from repository started");
        Movie foundMovie = movieRepository.getMovieByTitle(title);
        if(foundMovie != null){
            LOGGER.info("Movie with title " + title + " successfully found in repository.");
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setMovieId(foundMovie.getMovieId());
            movieResponse.setTitle(foundMovie.getTitle());
            movieResponse.setDirector(foundMovie.getDirector());
            movieResponse.setDescription(foundMovie.getDescription());
            movieResponse.setDuration(foundMovie.getDuration());
            movieResponse.setReleaseDate(foundMovie.getReleaseDate());
            movieResponse.setMark(foundMovie.getMark());
            movieResponse.setImage(foundMovie.getImage());
            movieResponse.setFilmGenreId(foundMovie.getFilmGenre().getFilmGenreId());
            return movieResponse;
        } else {
            LOGGER.warn("No movie with title: " + title + " found in repository");
            return new MovieResponse();
        }
    }

    @Override
    public List<MovieResponse> getMoviesOfSpecifiedFilmGenre(Long filmGenreId) {
        LOGGER.info("Getting movies with filmGenreId: " + filmGenreId + "from repository started");
        return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                .map(movie -> new MovieResponse(movie.getMovieId(),movie.getTitle(),movie.getDirector(),movie.getDescription(),movie.getDuration(),movie.getReleaseDate(),movie.getMark(),movie.getImage(),movie.getFilmGenre().getFilmGenreId()))
                .filter(movieResponse -> movieResponse.getFilmGenreId() == filmGenreId)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewMovie(MovieRequest newMovieRequest) {
        LOGGER.info("Adding new movie,tile: " + newMovieRequest.getTitle() + " started.");
        Movie newMovie = new Movie();
        newMovie.setTitle(newMovieRequest.getTitle());
        newMovie.setDirector(newMovieRequest.getDirector());
        newMovie.setDescription(newMovieRequest.getDescription());
        newMovie.setDuration(newMovieRequest.getDuration());
        newMovie.setReleaseDate(newMovieRequest.getReleaseDate());
        newMovie.setMark(newMovieRequest.getMark());
        newMovie.setImage(newMovieRequest.getImage());
        if (filmGenreRepository.getFilmGenreByFilmGenreId(newMovieRequest.getFilmGenreId()) != null) {
            newMovie.setFilmGenre(filmGenreRepository.getFilmGenreByFilmGenreId(newMovieRequest.getFilmGenreId()));
            Movie savedMovie = movieRepository.save(newMovie);
            if (movieRepository.getMovieByMovieId(savedMovie.getMovieId()) != null) {
                LOGGER.info("New movie,tile: " + savedMovie.getTitle() + " added successfully");
            } else {
                LOGGER.error("New movie,tile: " + savedMovie.getTitle() + " not added successfully");
            }
        }
     else {
            LOGGER.warn("No such filmGenre with filmGenreId: " + newMovieRequest.getFilmGenreId() + " found in repository");
        }
    }

}

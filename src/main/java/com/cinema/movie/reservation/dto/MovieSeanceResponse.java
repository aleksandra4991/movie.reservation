package com.cinema.movie.reservation.dto;

public class MovieSeanceResponse {

    private Long movieSeanceId;
    private String projectionDate;
    private Long movieId;
    private String movieTitle;
    private Long cinemaHallId;

    public MovieSeanceResponse() {
    }

    public MovieSeanceResponse(Long movieSeanceId, String projectionDate, Long movieId, String movieTitle, Long cinemaHallId) {
        this.movieSeanceId = movieSeanceId;
        this.projectionDate = projectionDate;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.cinemaHallId = cinemaHallId;
    }

    public Long getMovieSeanceId() {
        return movieSeanceId;
    }

    public String getProjectionDate() {
        return projectionDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setMovieSeanceId(Long movieSeanceId) {
        this.movieSeanceId = movieSeanceId;
    }

    public void setProjectionDate(String projectionDate) {
        this.projectionDate = projectionDate;
    }

    public void setMovieId(Long movieId) {
        this. movieId =  movieId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}

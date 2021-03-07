package com.cinema.movie.reservation.dto;


public class MovieSeanceRequest {

    private String projectionDate;
    private Long movieId;
    private String movieTitle;
    private Long cinemaHallId;

    public MovieSeanceRequest() {
    }

    public MovieSeanceRequest(String projectionDate, Long movieId, String movieTitle, Long cinemaHallId) {
        this.projectionDate = projectionDate;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.cinemaHallId = cinemaHallId;
    }

    public String getProjectionDate() {
        return projectionDate;
    }

    public void setProjectionDate(String projectionDate) {
        this.projectionDate = projectionDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieId(Long movieId) {
        this. movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}

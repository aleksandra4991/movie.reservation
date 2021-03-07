package com.cinema.movie.reservation.dto;

public class MovieRequest {

    private String title;
    private String director;
    private String description;
    private String duration;
    private String releaseDate;
    private double mark;
    private String image;
    private Long filmGenreId;

    public MovieRequest() {
    }

    public MovieRequest(String title, String director, String description, String duration, String releaseDate, double mark, String image, Long filmGenreId) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.mark = mark;
        this.image = image;
        this.filmGenreId = filmGenreId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getFilmGenreId() {
        return filmGenreId;
    }

    public void setFilmGenreId(Long filmGenreId) {
        this.filmGenreId = filmGenreId;
    }
}

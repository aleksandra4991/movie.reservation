package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MOVIE_ID", unique = true)
    private Long movieId;
    private String title;
    private String director;
    private String description;
    private String duration;
    private String releaseDate;
    private double mark;
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FILMGENRE_ID")
    private FilmGenre filmGenre;

    @OneToMany(targetEntity = MovieSeance.class, mappedBy = "movie",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <MovieSeance> movieSeances = new ArrayList<>();

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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

    public String getReleaseDate() { return releaseDate;    }

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

    public FilmGenre getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(FilmGenre filmGenre) {
        this.filmGenre = filmGenre;
    }

    public List<MovieSeance> getMovieSeances() {
        return movieSeances;
    }

    public void setMovieSeances(List<MovieSeance> movieSeances) {
        this.movieSeances = movieSeances;
    }
}

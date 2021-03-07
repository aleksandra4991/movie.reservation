package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "CINEMAHALL_ID", unique = true)
    private Long cinemaHallId;
    private String name;

    @OneToMany(targetEntity = Place.class, mappedBy = "cinemaHall",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <Place> places = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Cinema cinema;
    @OneToMany(targetEntity = MovieSeance.class, mappedBy = "cinemaHall",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <MovieSeance> movieSeance = new ArrayList<>();

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<MovieSeance> getMovieSeance() {
        return movieSeance;
    }

    public void setMovieSeance(List<MovieSeance> movieSeance) {
        this.movieSeance = movieSeance;
    }
}

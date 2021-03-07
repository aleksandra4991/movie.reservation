package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieSeance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MOVIESEANCE_ID", unique = true)
    private Long movieSeanceId;
    private String projectionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CINEMAHALL_ID")
    private CinemaHall cinemaHall;
    @OneToMany(targetEntity = CinemaTicket.class, mappedBy = "movieSeance",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <CinemaTicket> cinemaTickets = new ArrayList<>();

    public Long getMovieSeanceId() {
        return movieSeanceId;
    }

    public void setMovieSeanceId(Long movieSeanceId) {
        this.movieSeanceId = movieSeanceId;
    }

    public String getProjectionDate() {
        return projectionDate;
    }

    public void setProjectionDate(String projectionDate) {
        this.projectionDate = projectionDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public List<CinemaTicket> getCinemaTickets() {
        return cinemaTickets;
    }

    public void setCinemaTickets(List<CinemaTicket> cinemaTickets) {
        this.cinemaTickets = cinemaTickets;
    }
}

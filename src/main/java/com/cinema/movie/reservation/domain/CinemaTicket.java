package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CinemaTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "CINEMATICKET_ID", unique = true)
    private Long cinemaTicketId;
    private double price;
    private String clientEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIESEANCE_ID")
    private MovieSeance movieSeance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLACE_ID")
    private Place place;

    public Long getCinemaTicketId() {
        return cinemaTicketId;
    }

    public void setCinemaTicketId(Long cinemaTicketId) {
        this.cinemaTicketId = cinemaTicketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public MovieSeance getMovieSeance() {
        return movieSeance;
    }

    public void setMovieSeance(MovieSeance movieSeance) {
        this.movieSeance = movieSeance;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}

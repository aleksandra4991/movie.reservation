package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "PLACE_ID", unique = true)
    private Long placeId;
    private boolean reserved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CINEMAHALL_ID")
    private CinemaHall cinemaHall;
    @OneToOne(mappedBy = "place")
    private CinemaTicket cinemaTicket;

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public CinemaTicket getCinemaTicket() {
        return cinemaTicket;
    }

    public void setCinemaTicket(CinemaTicket cinemaTicket) {
        this.cinemaTicket = cinemaTicket;
    }
}

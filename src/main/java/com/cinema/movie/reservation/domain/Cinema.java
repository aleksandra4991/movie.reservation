package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "CINEMA_ID", unique = true)
    private Long cinemaId;
    private String name;

    @OneToMany(targetEntity = CinemaHall.class, mappedBy = "cinema",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <CinemaHall> cinemaHall = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CITY_ID")
    private City city;

    public Long getCinemaId(){
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaHall> getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(List<CinemaHall> cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

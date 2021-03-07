package com.cinema.movie.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FilmGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "FILMGENRE_ID", unique = true)
    private Long filmGenreId;
    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(targetEntity = Movie.class, mappedBy = "filmGenre",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <Movie> movies = new ArrayList<>();

    public Long getFilmGenreId() {
        return filmGenreId;
    }

    public void setFilmGenreId(Long filmGenreId) {
        this.filmGenreId = filmGenreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

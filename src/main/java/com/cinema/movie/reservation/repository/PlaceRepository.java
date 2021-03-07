package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository <Place, Long> {

    Place findPlaceByPlaceId(Long placeId);
}

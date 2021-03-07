package com.cinema.movie.reservation.repository;

import com.cinema.movie.reservation.domain.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository <City, Long> {

    City getCityByCityId (Long cityId);

    @Query("SELECT c FROM City c WHERE c.name = :name")
    public City getCityByName(@Param("name") String name);
}

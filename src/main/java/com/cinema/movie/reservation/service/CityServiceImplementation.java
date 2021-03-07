package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.City;
import com.cinema.movie.reservation.dto.CityRequest;
import com.cinema.movie.reservation.dto.CityResponse;
import com.cinema.movie.reservation.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityServiceImplementation implements CityService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImplementation.class);

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImplementation(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityResponse> getAllCities() {
        LOGGER.info("Getting all cities from repository started");
        return StreamSupport.stream(cityRepository.findAll().spliterator(),false)
                .map(city -> new CityResponse(city.getCityId(),city.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CityResponse getCityByName(String name) {
        LOGGER.info("Getting city: " + name + " from repository started");
        City foundCity = cityRepository.getCityByName(name);
        if(foundCity != null){
            LOGGER.info("City: " + name + " successfully found in repository.");
            CityResponse cityResponse = new CityResponse();
            cityResponse.setCityId(foundCity.getCityId());
            cityResponse.setName(foundCity.getName());
            return cityResponse;
        } else {
            LOGGER.warn("No city: " + name + " found in repository");
            return new CityResponse();
        }
    }

    @Override
    public void addNewCity(CityRequest cityRequest) {
        LOGGER.info("Adding new city, name: " + cityRequest.getName() + " started.");
        City newCity = new City();
        newCity.setName(cityRequest.getName());
        City savedCity = cityRepository.save(newCity);
        if(cityRepository.getCityByCityId(savedCity.getCityId()) != null){
            LOGGER.info("New city,name: " + savedCity.getName() + " added successfully");
        } else {
            LOGGER.error("New city,name: " + savedCity.getName() + " not added successfully");
        }
    }

}

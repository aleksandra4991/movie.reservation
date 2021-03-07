package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.Cinema;
import com.cinema.movie.reservation.dto.CinemaRequest;
import com.cinema.movie.reservation.dto.CinemaResponse;
import com.cinema.movie.reservation.repository.CinemaRepository;
import com.cinema.movie.reservation.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CinemaServiceImplementation implements CinemaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaServiceImplementation.class);
    private final CinemaRepository cinemaRepository;
    private final CityRepository cityRepository;

    @Autowired
    public CinemaServiceImplementation(CinemaRepository cinemaRepository, CityRepository cityRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CinemaResponse> getAllCinemas() {
        LOGGER.info("Getting all cinemas from repository started");
        return StreamSupport.stream(cinemaRepository.findAll().spliterator(),false)
                .map(cinema -> new CinemaResponse(cinema.getCinemaId(),cinema.getName(),cinema.getCity().getCityId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CinemaResponse> getCinemasFromRequestedCity(Long cityId) {
        LOGGER.info("Getting cinemas with cityId: " + cityId + " from repository started");
        return StreamSupport.stream(cinemaRepository.findAll().spliterator(), false)
                .map(cinema -> new CinemaResponse(cinema.getCinemaId(),cinema.getName(),cinema.getCity().getCityId()))
                .filter(cinemaResponse -> cinemaResponse.getCityId() == cityId)
                .collect(Collectors.toList());
    }

    @Override
    public CinemaResponse getCinemaByName(String name) {
        LOGGER.info("Getting cinema with name: " + name + " from repository started");
        Cinema foundCinema = cinemaRepository.getCinemaByName(name);
        if(foundCinema != null){
            LOGGER.info("Cinema with name " + name + " successfully found in repository.");
            CinemaResponse cinemaResponse = new CinemaResponse();
            cinemaResponse.setCinemaId(foundCinema.getCinemaId());
            cinemaResponse.setName(foundCinema.getName());
            cinemaResponse.setCityId(foundCinema.getCity().getCityId());
            return cinemaResponse;
        } else {
            LOGGER.warn("No cinema with name: " + name + " found in repository");
            return new CinemaResponse();
        }
    }

    @Override
    public void addNewCinema(CinemaRequest cinemaRequest) {
        LOGGER.info("Adding new cinema,name: " + cinemaRequest.getName() + " started.");
        Cinema newCinema = new Cinema();
        newCinema.setName(cinemaRequest.getName());
        if (cityRepository.getCityByCityId(cinemaRequest.getCityId()) != null) {
            newCinema.setCity(cityRepository.getCityByCityId(cinemaRequest.getCityId()));
            Cinema savedCinema = cinemaRepository.save(newCinema);
            if (cinemaRepository.getCinemaByCinemaId(savedCinema.getCinemaId()) != null) {
                LOGGER.info("New cinema,name: " + savedCinema.getName() + " added successfully");
            } else {
                LOGGER.error("New cinema,name: " + savedCinema.getName() + " not added successfully");
            }
        }
        else {
            LOGGER.warn("No such city with cityId: " + cinemaRequest.getCityId() + " found in repository");
        }
    }

}

package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.Cinema;
import com.cinema.movie.reservation.domain.CinemaHall;
import com.cinema.movie.reservation.dto.CinemaHallRequest;
import com.cinema.movie.reservation.dto.CinemaHallResponse;
import com.cinema.movie.reservation.dto.CinemaResponse;
import com.cinema.movie.reservation.repository.CinemaHallRepository;
import com.cinema.movie.reservation.repository.CinemaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CinemaHallServiceImplementation implements CinemaHallService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaServiceImplementation.class);
    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaHallServiceImplementation(CinemaHallRepository cinemaHallRepository, CinemaRepository cinemaRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<CinemaHallResponse> getAllCinemaHalls() {
        LOGGER.info("Getting all cinemaHalls from repository started");
        return StreamSupport.stream(cinemaHallRepository.findAll().spliterator(),false)
                .map(cinemaHall -> new CinemaHallResponse(cinemaHall.getCinemaHallId(),cinemaHall.getName(),cinemaHall.getCinema().getCinemaId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CinemaHallResponse> getAllCinemaHallsFromSpecifiedCinema(Long cinemaId) {
        LOGGER.info("Getting cinemaHalls from cinema with id: " + cinemaId + " from repository started");
        return StreamSupport.stream(cinemaHallRepository.findAll().spliterator(), false)
                .map(cinemaHall -> new CinemaHallResponse(cinemaHall.getCinemaHallId(),cinemaHall.getName(),cinemaHall.getCinema().getCinemaId()))
                .filter(cinemaHallResponse -> cinemaHallResponse.getCinemaId() == cinemaId)
                .collect(Collectors.toList());
    }

    @Override
    public List <CinemaHallResponse> getSpecifiedCinemaHallFromSpecifiedCinema(Long cinemaId, Long cinemaHallId) {
        LOGGER.info("Getting specified cinemaHall from specified cinema started; cinemaId: " + cinemaId + " ,cinemaHallId: " + cinemaHallId);
        return StreamSupport.stream(cinemaHallRepository.findAll().spliterator(), false)
                .map(cinemaHall -> new CinemaHallResponse(cinemaHall.getCinemaHallId(),cinemaHall.getName(),cinemaHall.getCinema().getCinemaId()))
                .filter(cinemaHallResponse -> cinemaHallResponse.getCinemaId() == cinemaId)
                .filter(cinemaHallResponse -> cinemaHallResponse.getCinemaHallId() == cinemaHallId)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewCinemaHall(CinemaHallRequest cinemaHallRequest) {
        LOGGER.info("Adding new cinemaHall,name: " + cinemaHallRequest.getName() + " started.");
        CinemaHall newCinemaHall = new CinemaHall();
        newCinemaHall.setName(cinemaHallRequest.getName());
        if (cinemaRepository.getCinemaByCinemaId(cinemaHallRequest.getCinemaId()) != null) {
            newCinemaHall.setCinema(cinemaRepository.getCinemaByCinemaId(cinemaHallRequest.getCinemaId()));
            CinemaHall savedCinemaHall = cinemaHallRepository.save(newCinemaHall);
            if (cinemaHallRepository.getCinemaHallByCinemaHallId(savedCinemaHall.getCinemaHallId()) != null) {
                LOGGER.info("New cinemaHall,name: " + savedCinemaHall.getName() + " added successfully");
            } else {
                LOGGER.error("New cinemaHall,name: " + savedCinemaHall.getName() + " not added successfully");
            }
        }
        else {
            LOGGER.warn("No such cinema with cinemaId: " + cinemaHallRequest.getCinemaId() + " found in repository");
        }
    }
}

package com.cinema.movie.reservation.service;

import com.cinema.movie.reservation.domain.CinemaTicket;
import com.cinema.movie.reservation.domain.Place;
import com.cinema.movie.reservation.dto.PlaceRequest;
import com.cinema.movie.reservation.dto.PlaceResponse;
import com.cinema.movie.reservation.repository.CinemaHallRepository;
import com.cinema.movie.reservation.repository.CinemaTicketRepository;
import com.cinema.movie.reservation.repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlaceServiceImplemantation implements PlaceService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceServiceImplemantation.class);

    private final PlaceRepository placeRepository;
    private final CinemaTicketRepository cinemaTicketRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public PlaceServiceImplemantation(PlaceRepository placeRepository, CinemaTicketRepository cinemaTicketRepository, CinemaHallRepository cinemaHallRepository) {
        this.placeRepository = placeRepository;
        this.cinemaTicketRepository = cinemaTicketRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public List<PlaceResponse> getAllPlaces() {
        LOGGER.info("Getting all places from repository started");
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                .map(place -> new PlaceResponse(place.getPlaceId(),place.isReserved(),place.getCinemaHall().getCinemaHallId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceResponse> getAllPlacesFromSpecifiedCinemaHall(Long cinemaHallId) {
        LOGGER.info("Getting places from specified cinemaHall with cinemaHallId: " + cinemaHallId + "from repository started");
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                .map(place -> new PlaceResponse(place.getPlaceId(),place.isReserved(),place.getCinemaHall().getCinemaHallId()))
                .filter(placeResponse -> placeResponse.getCinemaHallId() == cinemaHallId)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceResponse> getSpecifiedPlaceFromSpecifiedCinemaHall(Long placeId, boolean reserved, Long cinemaHallId) {
        LOGGER.info("Getting specified not reserved place with placeId: " + placeId + "from specified cinemaHall with cinemaHallId: " + cinemaHallId + "from repository started");
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                .map(place -> new PlaceResponse(place.getPlaceId(),place.isReserved() == false,place.getCinemaHall().getCinemaHallId()))
                .filter(placeResponse -> placeResponse.getCinemaHallId() == cinemaHallId)
                .filter(placeResponse -> placeResponse.getPlaceId() == placeId)
                .collect(Collectors.toList());
    }

    @Override
    public void reserveSpecifiedPlace(boolean reserved, Long cinemaTicketId) {
        LOGGER.info("Looking for specified cinemaTicket, id: " + cinemaTicketId);
        CinemaTicket boughtCinemaTicket = cinemaTicketRepository.getCinemaTicketByCinemaTicketId(cinemaTicketId);
        LOGGER.info("Looking for specified place with placeId: " + boughtCinemaTicket.getPlace().getPlaceId());
        Place placeToReservation = placeRepository.findPlaceByPlaceId(boughtCinemaTicket.getPlace().getPlaceId());
        if(boughtCinemaTicket != null && placeToReservation != null && placeToReservation.isReserved() == false){
            placeToReservation.setReserved(true);
            LOGGER.info("Specified place to cinemaTicket with cinemaTicketId: " + cinemaTicketId + " reserved");
            placeRepository.save(placeToReservation);
        } else {
            LOGGER.error("Not able to reserve place to cinemaTicket with cinemaTicketId: " + cinemaTicketId);
        }
    }

    @Override
    public List<PlaceResponse> getSpecifiedReservedPlaceFromSpecifiedCinemaHall(Long placeId, boolean reserved, Long cinemaHallId) {
        LOGGER.info("Getting specified reserved place with placeId: " + placeId + "from specified cinemaHall with cinemaHallId: " + cinemaHallId + "from repository started");
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                .map(place -> new PlaceResponse(place.getPlaceId(),place.isReserved() == true,place.getCinemaHall().getCinemaHallId()))
                .filter(placeResponse -> placeResponse.getCinemaHallId() == cinemaHallId)
                .filter(placeResponse -> placeResponse.getPlaceId() == placeId)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewPlace(PlaceRequest newPlaceRequest) {
        LOGGER.info("Adding new place,place in cinemaHallId with id: " + newPlaceRequest.getCinemaHallId() + " started.");
        Place place = new Place();
        place.setReserved(false);
        if (cinemaHallRepository.getCinemaHallByCinemaHallId(newPlaceRequest.getCinemaHallId()) != null){
            place.setCinemaHall(cinemaHallRepository.getCinemaHallByCinemaHallId(newPlaceRequest.getCinemaHallId()));
            Place savedPlace = placeRepository.save(place);
            if (placeRepository.findPlaceByPlaceId(savedPlace.getPlaceId()) != null) {
                LOGGER.info("New place,placeId: " + savedPlace.getPlaceId() + " added successfully");
            } else {
                LOGGER.error("New place,placeId: " + savedPlace.getPlaceId() + " not added successfully");
            }
        }
        else {
            LOGGER.warn("No such cinemaHall with cinemaHallId: " + newPlaceRequest.getCinemaHallId()
                    + " found in repository");
        }
    }
}

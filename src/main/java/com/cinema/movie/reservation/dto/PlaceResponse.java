package com.cinema.movie.reservation.dto;

public class PlaceResponse {

    private Long placeId;
    private boolean reserved = false;
    private Long cinemaHallId;
    private Long cinemaTicketId;

    public PlaceResponse() {
    }

    public PlaceResponse(Long placeId, boolean reserved, Long cinemaHallId) {
        this.placeId = placeId;
        this.reserved = reserved;
        this.cinemaHallId = cinemaHallId;
    }

    public PlaceResponse(Long placeId, boolean reserved, Long cinemaHallId, Long cinemaTicketId) {
        this.placeId = placeId;
        this.reserved = reserved;
        this.cinemaHallId = cinemaHallId;
        this.cinemaTicketId = cinemaTicketId;
    }

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
        reserved = false;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Long getCinemaTicketId() {
        return cinemaTicketId;
    }

    public void setCinemaTicketId(Long cinemaTicketId) {
        this.cinemaTicketId = cinemaTicketId;
    }
}

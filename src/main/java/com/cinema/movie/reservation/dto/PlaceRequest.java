package com.cinema.movie.reservation.dto;

public class PlaceRequest {

    private Long cinemaHallId;
    private boolean reserved = false;
    private Long cinemaTicketId;

    public PlaceRequest() {
    }

    public PlaceRequest(Long cinemaHallId, boolean reserved, Long cinemaTicketId) {
        this.cinemaHallId = cinemaHallId;
        this.reserved = reserved;
        this.cinemaTicketId = cinemaTicketId;
    }

    public PlaceRequest(Long cinemaHallId, boolean reserved) {
        this.cinemaHallId = cinemaHallId;
        this.reserved = reserved;
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

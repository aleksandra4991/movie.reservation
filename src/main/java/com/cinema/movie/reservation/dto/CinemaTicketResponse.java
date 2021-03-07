package com.cinema.movie.reservation.dto;

public class CinemaTicketResponse {

    private Long cinemaTicketId;
    private double price;
    private String clientEmail;
    private Long movieSeanceId;
    private Long placeId;

    public CinemaTicketResponse() {
    }

    public CinemaTicketResponse(Long cinemaTicketId, double price, String clientEmail, Long movieSeanceId, Long placeId) {
        this.cinemaTicketId = cinemaTicketId;
        this.price = price;
        this.clientEmail = clientEmail;
        this.movieSeanceId = movieSeanceId;
        this.placeId = placeId;
    }

    public Long getCinemaTicketId() {
        return cinemaTicketId;
    }

    public void setCinemaTicketId(Long cinemaTicketId) {
        this.cinemaTicketId = cinemaTicketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Long getMovieSeanceId() {
        return movieSeanceId;
    }

    public void setMovieSeanceId(Long movieSeanceId) {
        this.movieSeanceId = movieSeanceId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
}

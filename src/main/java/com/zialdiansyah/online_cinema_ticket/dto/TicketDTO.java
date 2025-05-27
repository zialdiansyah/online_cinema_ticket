package com.zialdiansyah.online_cinema_ticket.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketDTO {
    private Integer ticketId;
    private String movieTitle;
    private String cinemaName;
    private String studioName;
    private LocalDateTime startTime;
    private BigDecimal price;
    private Integer seatRow;
    private Integer seatColumn;
    private String bookingStatus;

    public Integer getTicketId() {
        return ticketId;
    }
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCinemaName() {
        return cinemaName;
    }
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getStudioName() {
        return studioName;
    }
    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSeatRow() {
        return seatRow;
    }
    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }
    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}

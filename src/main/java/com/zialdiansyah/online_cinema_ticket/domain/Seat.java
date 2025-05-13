package com.zialdiansyah.online_cinema_ticket.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    private Integer seatRow;

    private Integer seatColumn;

    private Integer rowPosition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status;

    public Integer getSeatId() {
        return seatId;
    }
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
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

    public Integer getRowPosition() {
        return rowPosition;
    }
    public void setRowPosition(Integer rowPosition) {
        this.rowPosition = rowPosition;
    }

    public SeatStatus getStatus() {
        return status;
    }
    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}


package com.zialdiansyah.online_cinema_ticket.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "studios")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studioId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    public Integer getStudioId() {
        return studioId;
    }
    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}

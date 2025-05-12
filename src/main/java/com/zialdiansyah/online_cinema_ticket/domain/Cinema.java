package com.zialdiansyah.online_cinema_ticket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cinemas")
public class Cinema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Integer getCinemaId() {
        return cinemaId;
    }
    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
}

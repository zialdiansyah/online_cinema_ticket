package com.zialdiansyah.online_cinema_ticket.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zialdiansyah.online_cinema_ticket.domain.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    List<Cinema> findByCityCityId(Integer cityId);
}

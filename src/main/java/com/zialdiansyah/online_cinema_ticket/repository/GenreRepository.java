package com.zialdiansyah.online_cinema_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zialdiansyah.online_cinema_ticket.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}


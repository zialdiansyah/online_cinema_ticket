package com.zialdiansyah.online_cinema_ticket.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zialdiansyah.online_cinema_ticket.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>  {
    @Query("""
        SELECT DISTINCT s.movie FROM Schedule s
        WHERE s.startTime BETWEEN :startOfDay AND :endOfDay
        AND s.studio.cinema.city.cityId = :cityId
    """)
    List<Movie> findNowPlayingMoviesByCity(
        @Param("cityId") Integer cityId,
        @Param("startOfDay") LocalDateTime startOfDay,
        @Param("endOfDay") LocalDateTime endOfDay
    );
}

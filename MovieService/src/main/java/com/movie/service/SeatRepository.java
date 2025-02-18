
package com.movie.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.movie.service.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {


	Optional<Seat> getSeatByShowId(@Param(value = "showId") Long showId);

}
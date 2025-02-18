
package com.movie.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.movie.service.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

//	@Query("select s from Show s where s.movie_id = :movieId and s.start_time >= :startDate and s.start_time <= :endDate")
//	Optional<List<Show>> getShowByMovieId(@Param(value = "movieId") Long movieId, @Param(value = "startDate") LocalDateTime startDate, @Param(value = "endDate")  LocalDateTime endDate);

	Optional<Show> getShowById(@Param(value = "id") Long id);

}
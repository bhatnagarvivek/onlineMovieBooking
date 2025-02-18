
package com.movie.service.handler;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.service.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
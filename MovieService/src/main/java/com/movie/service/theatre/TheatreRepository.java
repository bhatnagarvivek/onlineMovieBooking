
package com.movie.service.theatre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.service.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
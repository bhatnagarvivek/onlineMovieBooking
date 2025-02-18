package com.movie.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/movie")
public class OnlineMovieBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieBookingApplication.class, args);
	}

//	record NewMovieRequest(
//		String description,
//		String director,
//		String genre,
//		String title,
//		LocalDate date,
//		String language,
//		int totalSeats,
//		int availableSeats,
//		int price
//		){}

}
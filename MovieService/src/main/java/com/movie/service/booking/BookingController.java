package com.movie.service.booking;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.dto.BookingRequest;
import com.movie.service.entity.Booking;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService BookingService) {
		this.bookingService = BookingService;
	}

	@GetMapping
	public ResponseEntity<List<Booking>> getTheatres(@RequestBody BookingRequest request) throws IllegalAccessException {
		return new ResponseEntity<List<Booking>>(bookingService.bookTickets(request), HttpStatus.OK);
	}

}
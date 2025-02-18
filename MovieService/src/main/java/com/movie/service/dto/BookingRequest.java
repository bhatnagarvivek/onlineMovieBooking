package com.movie.service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BookingRequest {

    private Long theatreId;

    private List<Integer> seats;

    private Long showId;
    
    private LocalDateTime bookingSlot;

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public LocalDateTime getBookingSlot() {
		return bookingSlot;
	}

	public void setBookingSlot(LocalDateTime bookingSlot) {
		this.bookingSlot = bookingSlot;
	}

  
}
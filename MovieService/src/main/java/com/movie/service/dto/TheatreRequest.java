package com.movie.service.dto;

import java.time.LocalDateTime;

public class TheatreRequest {

    private Long movieId;

    private String location;

    private LocalDateTime time;
    
    private Long id;

    private String name;

    private String town;

    private Long partner;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Long getPartner() {
		return partner;
	}

	public void setPartner(Long partner) {
		this.partner = partner;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}


    
}
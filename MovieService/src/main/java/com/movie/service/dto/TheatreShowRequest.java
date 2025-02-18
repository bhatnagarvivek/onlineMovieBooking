package com.movie.service.dto;

import java.util.ArrayList;
import java.util.List;

public class TheatreShowRequest {

    private String name;
    private String town;
    private Long partnerId;
    private List<ShowRequest> shows = new ArrayList<>();
    
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

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public List<ShowRequest> getShows() {
		return shows;
	}

	public void setShows(List<ShowRequest> shows) {
		this.shows = shows;
	}

	


    
}
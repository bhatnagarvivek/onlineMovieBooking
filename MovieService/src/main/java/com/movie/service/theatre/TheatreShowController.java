package com.movie.service.theatre;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.dto.TheatreShowRequest;

@RestController
@RequestMapping("/theatre-shows")
public class TheatreShowController {

	private final TheatreService theatreService;

	public TheatreShowController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}

	@PutMapping("/{theatreId}")
	public void handleShows(@PathVariable("theatreId") Long id, @RequestBody TheatreShowRequest req) {
		theatreService.handleShows(id, req);
	}

}
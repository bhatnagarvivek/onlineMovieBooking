package com.movie.service.theatre;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.dto.TheatreRequest;
import com.movie.service.entity.Theatre;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	private final TheatreService theatreService;

	public TheatreController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}

	@PostMapping
	public void addTheatre(@RequestBody TheatreRequest req) {
		theatreService.addTheatre(req);
	}

	@DeleteMapping("/{theatreId}")
	public void deleteTheatre(@PathVariable("theatreId") Long id) {
		theatreService.deleteTheatre(id);
	}

	@PutMapping("/{theatreId}")
	public void updateTheatre(@PathVariable("theatreId") Long id, @RequestBody TheatreRequest req) {
		theatreService.updateTheatre(id, req);
	}

	@GetMapping
	public ResponseEntity<List<Theatre>> getAllTheatres(@RequestParam(required = false) Long movieId,
          @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dateTime,
			@RequestParam(required = false) String town

	)
			throws IllegalAccessException {
		return new ResponseEntity<List<Theatre>>(theatreService.getAllTheatres(movieId, dateTime, town), HttpStatus.OK);
	}
	
//	@PutMapping("/{theatreShowId}")
//	public void handleShows(@PathVariable("theatreShowId") Long id, @RequestBody TheatreShowRequest req) {
//		theatreService.handleShows(id, req);
//	}

}
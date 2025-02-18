package com.movie.service.handler;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.entity.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public List<Movie> getMovies(@RequestParam(required = false) String title,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@RequestParam(required = false) String language, @RequestParam(required = false) String genre

	) {
		return movieService.getAllMovies(title, language, genre);
	}

	@PostMapping
	public void addMovie(@RequestBody MovieRequest movie) {
		movieService.addMovie(movie);
	}

	@DeleteMapping("/{movieId}")
	public void deleteMovie(@PathVariable("movieId") Long id) {
		movieService.deleteMovie(id);
	}

	@PutMapping("/{movieId}")
	public void updateMovie(@PathVariable("movieId") Long id, @RequestBody MovieRequest movie) {
		movieService.updateMovie(id, movie);
	}

}
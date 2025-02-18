package com.movie.service.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.movie.service.SeatRepository;
import com.movie.service.ShowRepository;
import com.movie.service.entity.Movie;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	private final ShowRepository showRepository;
	private final SeatRepository seatRepository;

	public MovieService(MovieRepository movieRepository, ShowRepository showRepository, SeatRepository seatRepository) {
		this.movieRepository = movieRepository;
		this.showRepository = showRepository;
		this.seatRepository = seatRepository;
	}

	public List<Movie> filterMovies(String title, String language, String genre) {
		List<Movie> movies = movieRepository.findAll();
		List<Movie> filteredMovies = new ArrayList<>();

		for (Movie movie : movies) {
			boolean match = true;

			if (title != null && !movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
				match = false;
			}
			if (language != null && !movie.getLanguage().equals(language)) {
				match = false;
			}
			if (genre != null && !movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
				match = false;
			}
			if (match) {
				filteredMovies.add(movie);
			}
		}

		return filteredMovies;
	}

	public List<Movie> getAllMovies(String title, String language, String genre) {
		if (title == null && language == null && genre == null) {
			return movieRepository.findAll();
		} else {
			return filterMovies(title, language, genre);
		}
	}

	public Movie getMovieById(@PathVariable("id") Long id) {
		return movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
	}

	public void bookTickets(@PathVariable("movieId") Long id, @PathVariable("tickets") Integer tickets,
			@PathVariable("payment") Integer payment) {
		Movie movie = getMovieById(id);

		int availableSeats = 100; // movie.getAvailableSeats();
		if (tickets > availableSeats) {
			throw new IllegalArgumentException("No seats available at this time.");
		}

		int calculatedTotalPrice = tickets * movie.getPrice();
		if (!payment.equals(calculatedTotalPrice)) {
			throw new IllegalArgumentException("Invalid total price.");
		}

		availableSeats -= tickets;
//        movie.setAvailableSeats(availableSeats);

		movieRepository.save(movie);
	}

	public void addMovie(@RequestBody MovieRequest request) {
		Movie movie = new Movie();
		movie.setGenre(request.getGenre());
		movie.setTitle(request.getTitle());
		movie.setLanguage(request.getLanguage());
		movie.setPrice(request.getPrice());
		movieRepository.save(movie);
	}

	public void deleteMovie(@PathVariable("movieId") Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

		movieRepository.delete(movie);
	}

	public void updateMovie(Long id, MovieRequest request) {

		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

		movie.setGenre(request.getGenre());
		movie.setTitle(request.getTitle());
		movie.setLanguage(request.getLanguage());
		movie.setPrice(request.getPrice());
		movieRepository.save(movie);
	}

//	public void bookTickets(BookingRequest request) {
//
//        Optional<Show> show = showRepository.getShowById(request.getShowId());
//        if (show.isPresent()) {
////        	Optional <Seat>  seat = seatRepository.getSeatByShowId(show.get().getId());
////        	if (seat.isPresent()) {
////        		seat.get().get
//        int availableSeats = show.get().getAvailableSeats();
//        int ticketCount = request.getSeats().size();
//        if (request.getSeats().size() > availableSeats) {
//            throw new IllegalArgumentException("No seats available at this time.");
//        }
//        
//
//        int calculatedTotalPrice = ticketCount * show.get().getMovie().getPrice();
//        if (!payment.equals(calculatedTotalPrice)) {
//            throw new IllegalArgumentException("Invalid total price.");
//        }
//
//        availableSeats -= tickets;
//        movie.setAvailableSeats(availableSeats);
//
//        movieRepository.save(movie);
//        }
//        }

}

package com.movie.service.theatre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.service.ShowRepository;
import com.movie.service.dto.ActionEnum;
import com.movie.service.dto.ShowRequest;
import com.movie.service.dto.TheatreRequest;
import com.movie.service.dto.TheatreShowRequest;
import com.movie.service.entity.Movie;
import com.movie.service.entity.Show;
import com.movie.service.entity.Theatre;
import com.movie.service.entity.User;
import com.movie.service.handler.MovieRepository;
import com.movie.service.user.UserRepository;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;

	public TheatreService(TheatreRepository theatreRepository, UserRepository userRepository, 
			MovieRepository movieRepository, ShowRepository showRepository) {
		this.theatreRepository = theatreRepository;
		this.userRepository = userRepository;
		this.movieRepository = movieRepository;
		this.showRepository = showRepository;
    }

	public List<Theatre> getAllTheatres(Long movieId,LocalDateTime dateTime, String town) 
			throws IllegalAccessException {
		if (movieId== null && town == null && dateTime == null) {
			return theatreRepository.findAll();
		} else {
			return filter(movieId, town ,dateTime);
		}
	}
	
	public List<Theatre> filter(Long movieId, String town, LocalDateTime time) {
		List<Theatre> theatres = theatreRepository.findAll();
		List<Theatre> filteredTheatres = new ArrayList<>();
		List<Show> filteredShows = new ArrayList<>();

		for (Theatre theatre : theatres) {
			boolean match = true;
			
			if (town != null && !theatre.getTown().equals(town)) {
				match = false;
			}
			for (Show show : theatre.getShows()) {
				boolean showMatch = true;

				if (movieId != null && !movieId.equals(show.getMovie().getId())) {
					showMatch = false;
				}
				if (time != null && show.getStartTime().isBefore(time)) {
					showMatch = false;
				}
				if (showMatch) {
					filteredShows.add(show);
				}

			}

			if (match) {
				theatre.setShows(filteredShows);
				filteredTheatres.add(theatre);
			}
		}

		return filteredTheatres;
	}

	public void handleShows(Long id, TheatreShowRequest request) {
		Theatre theatre = theatreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
//		theatre.setTown(request.getTown());
//		theatre.setName(request.getName());
//		User user = userRepository.findById(request.getPartnerId())
//				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + request.getPartnerId()));
//		theatre.setPartner(user);
		List<Show> shows = new ArrayList<>();
		for (ShowRequest showRequest : request.getShows()) {
			if (ActionEnum.DELETE.equals(showRequest.getAction())) {
				Show showToDelete = showRepository.findById(showRequest.getShowId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid show ID: " + showRequest.getShowId()));
				showRepository.delete(showToDelete);
			}
			Show show = (ActionEnum.UPDATE.equals(showRequest.getAction()) && null != showRequest.getShowId()) ?  
					showRepository.findById(showRequest.getShowId())
						.orElseThrow(() -> new IllegalArgumentException("Invalid show ID: " + showRequest.getShowId()))
						: new Show();
			show.setAvailableSeats(showRequest.getAvailableSeats());
			Movie movie = movieRepository.findById(showRequest.getMovieId())
					.orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + showRequest.getMovieId()));
			show.setMovie(movie);
			show.setTheater(theatre);
			show.setStartTime(showRequest.getStartTime());
			show.setEndTime(showRequest.getEndTime());
			shows.add(show);
		}
		theatre.setShows(shows);
		theatreRepository.save(theatre);
	}

	public void deleteTheatre(Long id) {
		Theatre theatre = theatreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid theatre ID: " + id));
		theatreRepository.delete(theatre);
	}

	public void updateTheatre(Long id, TheatreRequest request) {
		Theatre theatre = theatreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
		theatre.setTown(request.getTown());
		theatre.setName(request.getName());
		User user = userRepository.findById(request.getPartnerId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + request.getPartnerId()));
		theatre.setPartner(user);
       theatreRepository.save(theatre);
		
	}

	public void addTheatre(TheatreRequest request) {
		Theatre theatre = new Theatre();
		theatre.setTown(request.getTown());
		theatre.setName(request.getName());
		User user = userRepository.findById(request.getPartnerId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + request.getPartnerId()));
		theatre.setPartner(user);
		theatreRepository.save(theatre);
	}
}
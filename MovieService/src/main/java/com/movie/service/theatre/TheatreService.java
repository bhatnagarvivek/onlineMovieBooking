package com.movie.service.theatre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.service.dto.TheatreRequest;
import com.movie.service.entity.Show;
import com.movie.service.entity.Theatre;
import com.movie.service.entity.User;
import com.movie.service.user.UserRepository;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final UserRepository userRepository;

	public TheatreService(TheatreRepository showRepository, UserRepository userRepository) {
		this.theatreRepository = showRepository;
		this.userRepository = userRepository;
    }

	public List<Theatre> getAllTheatres(TheatreRequest request) throws IllegalAccessException {
		if (request.getMovieId() == null && request.getTown() == null && request.getTime() == null) {
			return theatreRepository.findAll();
		} else {
			return filter(request.getMovieId(),request.getTown() ,request.getTime());
		}
	}
	
	public List<Theatre> filter(Long movieId, String town, LocalDateTime time) {
		List<Theatre> theatres = theatreRepository.findAll();
		List<Theatre> filtered = new ArrayList<>();
		List<Show> filteredShow = new ArrayList<>();

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
					filteredShow.add(show);
				}

			}

			if (match) {
				theatre.setShows(filteredShow);
				filtered.add(theatre);
			}
		}

		return filtered;
	}

	public void addTheatre(TheatreRequest request) {
		Theatre theatre = new Theatre();
		theatre.setLocation(request.getLocation());
		theatre.setName(request.getName());
		User user = userRepository.findById(request.getPartner())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + request.getPartner()));
		theatre.setPartner(user);
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
		theatre.setLocation(request.getLocation());
		theatre.setName(request.getName());
		User user = userRepository.findById(request.getPartner())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + request.getPartner()));
		theatre.setPartner(user);
       theatreRepository.save(theatre);
		
	}
}
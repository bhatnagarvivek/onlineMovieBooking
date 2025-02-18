package com.movie.service.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movie.service.SeatRepository;
import com.movie.service.ShowRepository;
import com.movie.service.dto.BookingRequest;
import com.movie.service.entity.Booking;
import com.movie.service.entity.Show;
import com.movie.service.handler.MovieRepository;

@Service
public class BookingService {

    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    public BookingService(MovieRepository movieRepository, ShowRepository showRepository, SeatRepository seatRepository) {
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

   

 

//    @GetMapping("/booking/history")
//    public List<BookingHistory> getBookingHistory() {
//        List<Movie> movies = movieRepository.findAll();
//        List<BookingHistory> bookingHistory = new ArrayList<>();
//
//        for (Movie movie : movies) {
//            int bookedTickets = movie.getTotalSeats() - movie.getAvailableSeats();
//
//            if (bookedTickets > 0) {
//                int totalPrice = bookedTickets * movie.getPrice();
//
//                BookingHistory booking = new BookingHistory();
//                booking.setId(movie.getId());
//                booking.setTitle(movie.getTitle());
//                booking.setDirector(movie.getDirector());
//                booking.setDescription(movie.getDescription());
//                booking.setGenre(movie.getGenre());
//                booking.setDate(movie.getDate());
//                booking.setLocation(movie.getLocation());
//                booking.setBookedTickets(bookedTickets);
//                booking.setTotalPrice(totalPrice);
//                bookingHistory.add(booking);
//            }
//        }
//        return bookingHistory;
//    }



//    @PostMapping("/booking/{movieId}/{tickets}/{payment}")
//    public void bookTickets(
//            @PathVariable("movieId") Integer id,
//            @PathVariable("tickets") Integer tickets,
//            @PathVariable("payment") Integer payment
//    ) {
//        Movie movie = getMovieById(id);
//
//        int availableSeats = movie.getAvailableSeats();
//        if (tickets > availableSeats) {
//            throw new IllegalArgumentException("No seats available at this time.");
//        }
//
//        int calculatedTotalPrice = tickets * movie.getPrice();
//        if (!payment.equals(calculatedTotalPrice)) {
//            throw new IllegalArgumentException("Invalid total price.");
//        }
//
//        availableSeats -= tickets;
//        movie.setAvailableSeats(availableSeats);
//
//        movieRepository.save(movie);
//    }

   

       

	public List<Booking> bookTickets(BookingRequest request) {

        Optional<Show> show = showRepository.getShowById(request.getShowId());
        if (show.isPresent()) {
//        	Optional <Seat>  seat = seatRepository.getSeatByShowId(show.get().getId());
//        	if (seat.isPresent()) {
//        		seat.get().get
        int availableSeats = show.get().getAvailableSeats();
        int ticketCount = request.getSeats().size();
        if (request.getSeats().size() > availableSeats) {
            throw new IllegalArgumentException("No seats available at this time.");
        }
        

//        int calculatedTotalPrice = ticketCount * show.get().getMovie().getPrice();
//        if (!payment.equals(calculatedTotalPrice)) {
//            throw new IllegalArgumentException("Invalid total price.");
//        }
//
//        availableSeats -= tickets;
//        movie.setAvailableSeats(availableSeats);
//
//        movieRepository.save(movie);
        }
		return null;
        }
    
		
}
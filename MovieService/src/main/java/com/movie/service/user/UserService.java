package com.movie.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.service.entity.User;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository showRepository) {
		this.userRepository = showRepository;
	}

	public List<User> getUsers(UserRequest request) throws IllegalAccessException {
		if (validateRequest(request)) {
//			Optional<List<Show>> showsList = UserRepository.getShowByMovieId(request.getMovieId(), request.getSlot().withHour(0).withMinute(0).withSecond(0).withNano(0),
//					request.getSlot().withHour(23).withMinute(59).withSecond(59).withNano(999999999));
//			if (showsList.isPresent()) {
//				return showsList.get().stream().filter(item -> request.getTown().equals(item.getTheater().getLocation())).map(data -> data.getTheater()).collect(Collectors.toList());
//			}
		} else {
			throw new IllegalAccessException("validation failed on request data");
		}
		return null;
	}

	private boolean validateRequest(UserRequest request) {
		// perform all needed validations on request params.
		// can customize here to identify and share what is invalid in request data.
		return true;

	}

	public void addUser(UserRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		userRepository.save(user);

	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));

		userRepository.delete(user);
	}

	public void updateUser(Long id, UserRequest request) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		userRepository.save(user);

	}
}
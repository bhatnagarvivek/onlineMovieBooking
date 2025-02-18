package com.movie.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.service.entity.User;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository showRepository) {
		this.userRepository = showRepository;
	}

	public List<User> getUsers(String name,String email, String role
			) throws IllegalAccessException {
		if (validateRequest(name,email, role)) {
			if (name == null && email == null && role == null) {
				return userRepository.findAll();
			} else {
				return filterUser(name,email, role);
			}
		} else {
			throw new IllegalAccessException("validation failed on request data");
		}
	}
	
	public List<User> filterUser(String name, String email, String role) {
		List<User> users = userRepository.findAll();
		List<User> filteredUsers = new ArrayList<>();

		for (User user : users) {
			boolean match = true;

			if (name != null && !user.getName().equals(name)) {
				match = false;
			}
			if (email != null && !user.getEmail().equals(email)) {
				match = false;
			}
			if (role != null && !user.getRole().equals(role)) {
				match = false;
			}
			if (match) {
				filteredUsers.add(user);
			}
		}

		return filteredUsers;
	}

	private boolean validateRequest(String name, String email, String role) {
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
		user.setBookingCount(request.getBookingCount());
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
		user.setBookingCount(request.getBookingCount());
		userRepository.save(user);

	}
}
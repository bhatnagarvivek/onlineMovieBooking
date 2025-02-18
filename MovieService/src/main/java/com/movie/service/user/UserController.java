package com.movie.service.user;

import java.util.List;

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

import com.movie.service.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public void addUser(@RequestBody UserRequest req) {
		userService.addUser(req);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long id) {
		userService.deleteUser(id);
	}

	@PutMapping("/{userId}")
	public void updateUser(@PathVariable("userId") Long id, @RequestBody UserRequest req) {
		userService.updateUser(id, req);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String name
			,@RequestParam(required = false) String email,
			@RequestParam(required = false) String role
			) throws IllegalAccessException {
		return new ResponseEntity<List<User>>(userService.getUsers(name, email, role), HttpStatus.OK);
	}

}
package com.sezo.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.demo.entity.User;
import com.sezo.demo.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/save")
	public ResponseEntity<User> AddUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/greeting/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id).orElse(new User(0L, "Default", "User"));
	}

	@GetMapping("/test")
	public Map<String, Object> welcome() {
		return Collections.singletonMap("message", "Hi There");

	}
}

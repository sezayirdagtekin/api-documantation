package com.sezo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.entity.User;
import com.sezo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;


	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}


	@PostMapping("/save/")
	public User AddUser(@RequestBody User user) {
		return userService.addUser(user);
	}


	@GetMapping("/greeting/{id}")
	public User getUser(  @PathVariable Long	 id) {
		return userService.getUser(id).orElse(new User(0L, "Default", "User"));
	}

}
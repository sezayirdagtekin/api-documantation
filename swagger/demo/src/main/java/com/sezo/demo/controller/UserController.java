package com.sezo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.demo.entity.User;
import com.sezo.demo.repo.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Get all users")
	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@ApiOperation(value = "Save user", notes = "Save and return same user",	response = User.class)
	@PostMapping("/save/")
	public User AddUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@ApiOperation(value = "Get user by id", notes = "Look up user  by id and return user",	response = User.class)
	@GetMapping("/greeting/{id}")
	public User getUser(@ApiParam(value = "ID value for User you need to retreive it", required = true)  @PathVariable Long	 id) {
		return userService.getUser(id).orElse(new User(0L, "Default", "User"));
	}

}
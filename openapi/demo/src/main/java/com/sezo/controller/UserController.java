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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.MediaType;

@RequestMapping("/user")
@RestController
@Tag(name = "User Management Controller")
public class UserController {

	@Autowired
	UserService userService;


	@GetMapping("/all")
	@Operation(description = "Get all users", summary = "All users")
	public List<User> getUsers() {
		return userService.getUsers();
	}


	@PostMapping("/save/")
	@Operation(description = "Save single user", summary = "Save user")
	public User AddUser(@RequestBody User user) {
		return userService.addUser(user);
	}


	@GetMapping("/greeting/{id}")
	@Operation(description = "Save single user", summary = "Save user" ,parameters = {@Parameter(name = "id" ,description = "User id", example = "1")},
			 responses = {@ApiResponse(responseCode ="200", content = @Content(schema = @Schema( implementation = User.class) , mediaType = org.springframework.http.MediaType.APPLICATION_JSON_VALUE))}
			)
	public User getUser(  @PathVariable Long	 id) {
		return userService.getUser(id).orElse(new User(0L, "Default", "User"));
	}

}
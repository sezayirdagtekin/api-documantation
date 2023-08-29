package com.sezo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sezo.entity.User;

import lombok.extern.java.Log;

@Service
@Log
public class UserService {
	static List<User> users = new ArrayList<>();
	static {
		User sezayir = new User(1L, "Sezayir", "Dagtekin");
		users.add(sezayir);
		User cem = new User(2L, "Cem", "Davran");
		users.add(cem);
	}

	public List<User> getUsers() {
		log.info("Get all users");
		return users;
	}

	public User addUser(User user) {
		users.add(user);
		log.info(user + " is added");
		return user;
	}

	public Optional<User> getUser(Long id) {
		log.info("searh or user id=" + id);
		return users.stream().filter(u -> u.getId().equals(id)).findFirst();
	}

}

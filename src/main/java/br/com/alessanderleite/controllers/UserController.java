package br.com.alessanderleite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.entities.User;
import br.com.alessanderleite.repositories.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("users/{id}")
	public User findUserById(@PathVariable("id") User user) {
		return user;
	}
	
	@GetMapping("/users")
	public Page<User> findAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	@GetMapping("/sortedusers")
	public Page<User> findAllUsersSortedByName() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));
		return userRepository.findAll(pageable);
	}
}

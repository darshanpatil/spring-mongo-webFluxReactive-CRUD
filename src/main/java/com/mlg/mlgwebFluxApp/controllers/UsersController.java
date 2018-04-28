/**
 * 
 */
package com.mlg.mlgwebFluxApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlg.mlgwebFluxApp.entity.Users;
import com.mlg.mlgwebFluxApp.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author darshan
 *
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserRepository userRepo;

	@GetMapping
	public Flux<Users> getAllUsers() {
		return userRepo.findAll();
	}

	@PostMapping
	public Mono<Users> createUser( @RequestBody Users user) {
		return userRepo.save(user);
	}

	@GetMapping("/id")
	public Mono<ResponseEntity<Users>> getUserById( @PathVariable( value = "id" ) int userId) {
		return userRepo.findById(userId)
				.map(resp -> ResponseEntity.ok(resp))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}

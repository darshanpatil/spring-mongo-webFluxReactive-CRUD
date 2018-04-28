/**
 * 
 */
package com.mlg.mlgwebFluxApp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mlg.mlgwebFluxApp.entity.Users;

import reactor.core.publisher.Flux;

/**
 * @author darshan
 *
 */
public interface UserRepository extends ReactiveMongoRepository<Users, Integer> {

	Flux<Users> findByName(String name);
}

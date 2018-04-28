package com.mlg.mlgwebFluxApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.mlg.mlgwebFluxApp.entity.Users;
import com.mlg.mlgwebFluxApp.repository.UserRepository;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class MlgWebFluxAppApplicationTests {

	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void saveUser() {
		Users user = new Users("Darshan", "26");
		userRepo.deleteAll().subscribe();
		
		webTestClient.post().uri("/users")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(user), Users.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString())
		.expectBody()
		.jsonPath("$.name").isEqualTo("Darshan");
	}

	public void testUserCount() {
		webTestClient.get().uri("/users")
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString())
		.expectBodyList(Users.class).hasSize(1);
	}
}

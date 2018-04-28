package com.mlg.mlgwebFluxApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mlg.mlgwebFluxApp.repository.UserRepository;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MlgWebFluxAppApplication {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MlgWebFluxAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			System.out.println(":::::::::::::::::::::: For data setup, if required ::::::::::::::::::::::");

		};
	}

	@Bean
	RouterFunction<ServerResponse> helloRouterFunction() {

		RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(RequestPredicates.path("/"),
				serverRequest -> ServerResponse.ok().body(Mono.just("Welcome to Spring Boot Application !!! "
						+ "This Application is developed using Spring 5, Spring Boot 2.0.x, WebFlux, and MongoDB on Cloud"), String.class));
		return routerFunction;
	}
}

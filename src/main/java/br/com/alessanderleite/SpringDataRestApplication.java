package br.com.alessanderleite;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alessanderleite.entities.User;
import br.com.alessanderleite.repositories.UserRepository;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}
	
	CommandLineRunner initialize(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Robert", "Nataly", "Helen", "Mary").forEach(name -> {
				User user = new User(name);
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}

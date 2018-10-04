package com.codecool.springbootdrinks;

import com.codecool.springbootdrinks.Service.LiquorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDrinksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDrinksApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LiquorService liquorService) {
		return (args) -> {
			liquorService.addData();
		};
	}
}


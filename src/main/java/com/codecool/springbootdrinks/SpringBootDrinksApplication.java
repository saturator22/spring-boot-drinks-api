package com.codecool.springbootdrinks;

import com.codecool.springbootdrinks.Service.EmailSender;
import com.codecool.springbootdrinks.Service.LiquorService;
import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.mail.internet.InternetAddress;

@SpringBootApplication
@EnableEmailTools
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


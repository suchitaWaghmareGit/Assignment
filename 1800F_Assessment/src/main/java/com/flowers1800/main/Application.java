package com.flowers1800.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@EntityScan("com.flowers1800.main.model")
@ComponentScan("com.flowers1800.main")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("welcome to 1800flowers");
		SpringApplication.run(Application.class, args);
	}

}

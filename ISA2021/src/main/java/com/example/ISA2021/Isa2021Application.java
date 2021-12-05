package com.example.ISA2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.ISA2021.Repository")
public class Isa2021Application {

	public static void main(String[] args) {
		SpringApplication.run(Isa2021Application.class, args);
	}

}

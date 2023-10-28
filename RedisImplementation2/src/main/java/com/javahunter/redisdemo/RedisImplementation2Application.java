package com.javahunter.redisdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.javahunter.redisdemo.entity")
@EnableJpaRepositories("com.javahunter.redisdemo.repository")
@ComponentScan("com.javahunter.*")
@OpenAPIDefinition
@SpringBootApplication
public class RedisImplementation2Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisImplementation2Application.class, args);
	}

}

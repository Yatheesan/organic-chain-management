package com.backend.api.backendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@Configuration
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

}

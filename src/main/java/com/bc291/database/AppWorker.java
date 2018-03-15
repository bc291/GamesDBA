package com.bc291.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppWorker {

	public static void main(String[] args) {
		SpringApplication.run(AppWorker.class, args);
	}
}

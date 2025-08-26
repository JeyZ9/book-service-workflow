package com.app.jeyz9.booksservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class BooksServiceApplication {

	@Bean
	CommandLineRunner checkUser(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("✅ Connected as: " + conn.getMetaData().getUserName());
			}
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(BooksServiceApplication.class, args);
	}

}

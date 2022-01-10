package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
//
//	public void run(String... args) throws Exception {
//
//		System.out.println("DATASOURCE = " + dataSource);
//
//		System.out.println("\n1.findAll()...");
//		for (UserEntity users : userRepository.findAll()) {
//			System.out.println(users);
//		}
//		
//		
//		System.out.println("===================DONE==============");
//	}

}

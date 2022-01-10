package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserAPI {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		users = userRepository.findAll();
		System.out.println(userRepository.findAll());
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}

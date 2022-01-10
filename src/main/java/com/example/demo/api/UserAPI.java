package com.example.demo.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserAPI {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IUserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		users = userRepository.findAll();
		System.out.println(userRepository.findAll());
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
//	@PostMapping("/user")
//	public UserEntity createUser(@RequestBody UserEntity user) {
//		return userRepository.save(user);
//	}
	
	@PostMapping("/user")
	public List<Map> insertUser(@RequestBody UserEntity userEntity) throws SQLException {
//		List<UserEntity> users = new ArrayList<UserEntity>();
//		users = userRepository.findAll();
//		System.out.println(userRepository.findAll());
		String email = userEntity.getEmail();
		String id = userEntity.getId();
		String phone = userEntity.getPhone();
		String password = userEntity.getPassword();
		String avatar = userEntity.getAvatar();
		System.out.println(email);
		return userService.save(id, email, password, phone, avatar);
	}
}

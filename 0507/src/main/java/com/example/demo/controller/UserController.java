package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:8081/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/Login")
	public String Login(@RequestBody User user) {
		
		return userService.Login(user);
	}
}

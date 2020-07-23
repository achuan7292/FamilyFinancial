package com.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.domain.User;
import com.family.service.UserService;

@RestController
public class Test {
	
	@Autowired
	UserService userService;
	@RequestMapping("/what")
	public void what() {
		User user = userService.findById("002");
		System.out.println(user);
	}
	

}

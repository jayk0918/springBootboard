package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.entity.Users;
import com.example.board.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@ResponseBody
	@PostMapping(value = "/loginCheck")
	public Users loginCheck(@RequestBody Users users) {
		return userService.loginCheck(users);
	}
	
}

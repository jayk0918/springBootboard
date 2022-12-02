package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.entity.Users;
import com.example.board.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/")
	public String index() {
		return "redirect:/loginForm";
	}
	
	@GetMapping(value = "/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping(value = "/registerForm")
	public String registerForm() {
		return "registerForm";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/loginForm";
	}
	
	@ResponseBody
	@PostMapping(value = "/userCheck")
	public Users userCheck(@RequestBody Users users, HttpSession session) {
		Users check = userService.userCheck(users);
		
		int userNo = check.getUserNo();
		String userName = check.getUserName();
		
		Users authUser = new Users(userNo, userName);
		session.setAttribute("authUser", authUser);
		
		return authUser;
	}
	
	@ResponseBody
	@PostMapping(value = "/duplicateCheck")
	public boolean duplicateCheck(@RequestBody String userId) {
		System.out.println("inputId : " + userId);
		boolean check = userService.duplicateCheck(userId);
		System.out.println("controller : " + check);
		return check;
	}
	
	// 반복 사용되는 세션 정보를 static에 정의함
	public static Users authUser(HttpSession session) {
		Users authUser = (Users) session.getAttribute("authUser");
		return authUser;
	}
	
}

package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.board.entity.Content;
import com.example.board.entity.Users;
import com.example.board.service.ContentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@GetMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		
		List<Content> list = contentService.getList();
		
		model.addAttribute("authUser", authUser(session));
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	
	
	// 반복 사용되는 세션 정보를 static에 정의함
	public static Users authUser(HttpSession session) {
		Users authUser = (Users) session.getAttribute("authUser");
		return authUser;
	}
}

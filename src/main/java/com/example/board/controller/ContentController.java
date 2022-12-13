package com.example.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping(value = "/detail")
	public String getContent(@RequestParam int contentNo, Model model, HttpSession session) {
		Content content = contentService.getContent(contentNo);
		
		model.addAttribute("authUser", authUser(session));
		model.addAttribute("content", content);
		
		return "detail";
	}
	
	@GetMapping(value = "/writeForm")
	public String getWriteForm(@ModelAttribute Content content) {
		return "writeForm";
	}
	
	@PostMapping(value = "/write")
	public String write(@RequestParam(value="title") String title,
						@RequestParam(value="contents") String contents,
						HttpSession session) {
		
		int userNo = authUser(session).getUserNo();
		
		Date now = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regdate = transFormat.format(now);
		
		Content saveContent = Content.builder().
								title(title).
								contents(contents).
								userNo(userNo).
								hit(1).
								regdate(regdate).
								build();
		
		contentService.write(saveContent);
		
		return "redirect:/list";
	}
	
	@ResponseBody
	@PostMapping(value="/delete")
	public void deleteContent(@RequestBody int contentNo) {
		contentService.deleteContent(contentNo);
	}
	
	
	@GetMapping(value = "editForm")
	public String getEditForm(@RequestParam int contentNo, Model model, HttpSession session ) {
		Content content = contentService.getContent(contentNo);
		
		model.addAttribute("authUser", authUser(session));
		model.addAttribute("content", content);
		
		return "editForm";
	}
	
	/*
	@PostMapping(value = "edit")
	public String edit(@RequestParam int contentNo, @ModelAttribute Content content) {
		
		contentService.updateContent(contentNo, content);
		
		return "redirect:/list";
	}
	*/
	
	
	// 반복 사용되는 세션 정보를 static에 정의함
	public static Users authUser(HttpSession session) {
		Users authUser = (Users) session.getAttribute("authUser");
		return authUser;
	}
	
}

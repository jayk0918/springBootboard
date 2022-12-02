package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.Content;
import com.example.board.entity.ContentRepository;

@Service
public class ContentService {
	
	@Autowired
	private ContentRepository contentRepository;
	
	public List<Content> getList(){
		List<Content> result = contentRepository.findAll();
		return result;
	}

}

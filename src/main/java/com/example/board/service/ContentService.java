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
		return contentRepository.findAllByOrderByContentNoDesc();
	}
	
	public Content getContent(int contentNo) {
		return contentRepository.findByContentNo(contentNo);
	}
	
	public Content write(Content content) {
		return contentRepository.save(content);
	}
	
	public void deleteContent(int contentNo) {
		contentRepository.deleteByContentNo(contentNo);
	}
	
	
}

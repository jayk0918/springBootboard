package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "content")
@Table(name = "board.contents")
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 게시글 리스트
	private String title;
	private String content;
	private int userNo;
	private String userName;
	private int contentNo;
	private String date;
	private int hit;
	
	
	// 게시글 등록 builder
	@Builder
	public Content(String title, String content, int userNo, String userName, int contentNo, String date,
			int hit) {
		this.title = title;
		this.content = content;
		this.userNo = userNo;
		this.userName = userName;
		this.contentNo = contentNo;
		this.date = date;
		this.hit = hit;
	}
	
}

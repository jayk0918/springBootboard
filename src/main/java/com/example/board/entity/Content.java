package com.example.board.entity;

import jakarta.persistence.Column;
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
@Table(name = "board_contents")
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int contentNo;
	
	// 게시글 리스트
	private String title;
	private String contents;
	private int userNo;
	//private String userName;
	private String regdate;
	private int hit;
	
	// 게시글 조회 builder
	@Builder
	public Content(String title, String contents, String regdate, int hit) {
		this.title = title;
		this.contents = contents;
		this.regdate =  regdate;
		this.hit = hit;
	}
	
	// 게시글 등록 builder
	@Builder
	public Content(String title, String contents, int userNo, int hit) {
		this.title = title;
		this.contents = contents;
		this.userNo = userNo;
		this.hit = hit;
	}
	
	
}

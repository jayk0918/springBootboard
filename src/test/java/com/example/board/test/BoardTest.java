package com.example.board.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.entity.UserRepository;
import com.example.board.entity.Users;

@SpringBootTest
public class BoardTest {
	
	@Autowired
	UserRepository boardRepository;
	
	@Test
	void save() {
		
		Users params = Users.builder()
				.userId("guest5")
				.userPassword("1234")
				.build();
		
		boardRepository.save(params);
		
		Users entity = boardRepository.findById((long) 6).get();
        assertThat(entity.getUserId()).isEqualTo("guest5");
        assertThat(entity.getUserPassword()).isEqualTo("1234");
		
	}
	
	@Test
    void findAll() {
		long boardsCount = boardRepository.count();
		List<Users> boards = boardRepository.findAll();
		
	}
	
	@Test
    void delete() {
        Users entity = boardRepository.findById((long) 3).get();
        boardRepository.delete(entity);
    }
	
	
}

package com.example.board.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{
	
	List<Content> findAllByOrderByContentNoDesc();
	
	Content findByContentNo(int contentNo);
	
	@Transactional
	void deleteByContentNo(int contentNo);

}

package com.example.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	/*
	@Transactional
	@Modifying
	public Users findByUserId(String userId);
	*/
	
	Users findByUserIdAndUserPassword(String userId, String userPassword);
	boolean existsByUserId(String userId);
	
}
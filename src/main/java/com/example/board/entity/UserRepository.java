package com.example.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	
	@Transactional
	@Modifying
	public Users findByUserId(String userId);
	
	/*
	@Query(value = "select user_no, "
			+ "user_id, "
			+ "user_name, "
			+ "user_password "
			+ "from board_users "
			+ "where user_id = :userId "
			+ "and user_password = :userPassword ",
			nativeQuery=true)
	Users loginCheck(@Param("userId") String userId,
					 @Param("userPassword") String userPassword);
	*/
}
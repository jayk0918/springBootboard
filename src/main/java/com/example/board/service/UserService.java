package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.UserRepository;
import com.example.board.entity.Users;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;

	public Users userCheck(Users users) {
		String userId = users.getUserId();
		String userPassword = users.getUserPassword();
		
		System.out.println(userId + " " + userPassword);
		
		return userRepository.findByUserIdAndUserPassword(userId, userPassword);
	}
	
	public boolean duplicateCheck(String userId) {
		System.out.println("service : " + userId);
		boolean check = userRepository.existsByUserId(userId);
		System.out.println("service result : " + check);
		return check;
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		Users authUser = userRepository.findByUserId(userId);
		if(authUser == null) throw new UsernameNotFoundException("Not Found account");
		return authUser;
	}
	*/

	
	
}

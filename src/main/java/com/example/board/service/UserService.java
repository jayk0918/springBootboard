package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.board.entity.UserRepository;
import com.example.board.entity.Users;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public Users loginCheck(Users users) {
		String userId = users.getUserId();
		String userPassword = users.getUserPassword();
		return userRepository.loginCheck(userId, userPassword);
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		Users authUser = userRepository.loginCheck(userId);
		
		if(authUser == null) throw new UsernameNotFoundException("Not Found account");
		
		return authUser;
	}
	
	
}

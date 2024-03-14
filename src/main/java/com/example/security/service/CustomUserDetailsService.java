package com.example.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.dto.CustomUserDetails;
import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository; 
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userData = userRepository.findByUsername(username);
		
		if (userData != null) {
			
			return new CustomUserDetails(userData);
		}
		
		
		return null;
	}
	
}

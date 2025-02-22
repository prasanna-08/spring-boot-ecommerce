package com.prasanna.ecommerceproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prasanna.ecommerceproject.entity.UserEntity;
import com.prasanna.ecommerceproject.repository.UserRepository;

@Service
public class AuthService {

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private UserRepository userRepo;
	
	public String registerUser(String username, String password) {
		if(userRepo.findByUserName(username)!=null)
		{
			return "user already exists";
		}
		
		UserEntity user = new UserEntity();
		user.setName(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepo.save(user);
		
		return "User Registered Successfully";
	}
	
	public boolean authenticateUser(String username, String password)
	{
		UserEntity userr = new UserEntity();
		Optional<UserEntity> user = userRepo.findByUserName(username);
		if(user==null)
		{
			return false;
		}
		return passwordEncoder.matches(password,userr.getPassword());
	}
}

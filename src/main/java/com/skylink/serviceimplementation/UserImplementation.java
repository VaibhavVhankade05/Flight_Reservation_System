package com.skylink.serviceimplementation;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skylink.entity.User;
import com.skylink.repository.UserRepository;
import com.skylink.service.UserService;
//import com.system.management.student.entity.Student;


@Service
public class UserImplementation implements UserService
{
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	
//	For Registration Purpose
	@Override
	public User registerUser(User user) 
	{
		if (user == null || user.getEmail() == null || user.getPassword() == null) {
	        throw new IllegalArgumentException("User or required fields must not be null");
	    }

	    // Check if the email is already in use
	    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
	        throw new IllegalArgumentException("Email is already in use");
	    }

	    // Encode the password before saving
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    
	    return userRepository.save(user);	  
	}
	
	
	
// For Getting List Of User
	@Override
	public List<User> getAllUsers() 
	{
		return userRepository.findAll();
	}
	
	
	
//	Get By Id
	@Override
	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found" + id));
	}
	
	
	
// Update By Id
	@Override
	public User updateUser(Long id, User userdetails) 
	{
		return userRepository.findById(id).map(user -> 
		{
			user.setName(userdetails.getName());
			user.setEmail(userdetails.getEmail());
			user.setPassword(userdetails.getPassword());
			return userRepository.save(user);
		}).orElseThrow(() -> new RuntimeException("Student Not Found" + id));
	}
	
	
	
//  Delete By Id
	@Override
	public void deleteUser(Long id) 
	{
		if (!userRepository.existsById(id)) {
	        throw new RuntimeException("User not found with ID: " + id);
	    }
	    userRepository.deleteById(id);
	}
	
	
	}


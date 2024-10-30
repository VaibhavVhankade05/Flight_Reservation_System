package com.skylink.service;

import java.util.List;
//import java.util.Optional;

import com.skylink.entity.User;

public interface UserService 
{
	User registerUser(User user);
	
	List<User> getAllUsers();
	
    User getById(Long id);
    
//    Optional<User> findByEmail(String email);

    User updateUser(Long id, User user);
    
    void deleteUser(Long id);
    
//    boolean authenticate(String email, String password);

}

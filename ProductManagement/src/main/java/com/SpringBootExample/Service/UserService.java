package com.SpringBootExample.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBootExample.Entity.User;
import com.SpringBootExample.Repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userrepository;
	public User saveUser(User user) {
	
		return userrepository.save(user);
	}

	public void remove(Long id) {
		userrepository.deleteById(id);
	}
}

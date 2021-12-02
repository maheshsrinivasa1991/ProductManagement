package com.SpringBootExample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootExample.Entity.User;
import com.SpringBootExample.Repository.AdderssRepository;
import com.SpringBootExample.Repository.UserRepository;
import com.SpringBootExample.Service.UserService;
import com.SpringBootExample.exception.ResourceNotFoundException;

import lombok.Data;

@Data
@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userservice.saveUser(user);
	}
	
	
	@GetMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) throws ResourceNotFoundException {
		 User existingUser = this.userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 existingUser.setUsername(user.getUsername());
		 existingUser.setEmail(user.getEmail());
		 existingUser.setMobile(user.getMobile());
		 existingUser.setCreatedAt(user.getCreatedAt());
		 existingUser.setCreatedBy(user.getCreatedBy());
		 existingUser.setModifiefdAt(user.getModifiefdAt());
		 existingUser.setModifiedBy(user.getModifiedBy());
		 return this.userRepository.save(existingUser);
	}
	
	
	public void remove(Long id){
		userRepository.deleteById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId) throws ResourceNotFoundException{
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
}

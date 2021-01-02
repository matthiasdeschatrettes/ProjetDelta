package ynov.projetdelta.UserApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetdelta.UserApi.model.User;
import ynov.projetdelta.UserApi.repositories.UserRepository;

/**
 * CRUD API REST
 * 	CREATE / READ / UPDATE / DELETE
 * @author ryan
 *
 */
@RestController
public class RestUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public Iterable<User> getUsers() {		
		Iterable<User> users = userRepository.findAll();	
		System.out.println("trace getUsers");
		return users;		
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<User> user = userRepository.findById(id);		
		System.out.println("Retrieve " + user.get().getUsername());
		return user;		
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		user = userRepository.save(user);		
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		User currentUser = userRepository.findById(id).get();	
		
		String username = user.getUsername();
		if(username != null) {
			currentUser.setUsername(username);
		}		
		String password = user.getPassword();
		if(password != null) {
			currentUser.setPassword(password);
		}
		
		currentUser = userRepository.save(currentUser);
		return currentUser;
	}	
	
}
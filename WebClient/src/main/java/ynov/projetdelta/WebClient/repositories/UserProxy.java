package ynov.projetdelta.WebClient.repositories;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ynov.projetdelta.WebClient.model.User;

@Repository
public class UserProxy extends GenericProxy {
	
	public User getUser(int id) {
		
		String getUserUrl = props.getApiUrl() + "/user/" + id;
		
		ResponseEntity<User> response = restTemplate.exchange(
				getUserUrl, 
				HttpMethod.GET, 
				null, 
				User.class);
		
		return response.getBody();	
	}
	
	@CircuitBreaker(name ="proxy", fallbackMethod = "fallback")
	public Iterable<User> getUsers() {
		
		String getUsersUrl = props.getApiUrl() + "/user";
		
		ResponseEntity<Iterable<User>> response = restTemplate.exchange(
				getUsersUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<User>>() {});
		
		return response.getBody();
	}
	
	@SuppressWarnings("unused")
	private Iterable<User> fallback(IllegalStateException ex) {
		System.out.println("From fallback method IllegalState : " + ex.getMessage());
		return new ArrayList<User>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<User> fallback(TimeoutException ex) {
		System.out.println("From fallback method Timeout : " + ex.getMessage());
		return new ArrayList<User>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<User> fallback(HttpServerErrorException ex) {
		System.out.println("From fallback method HttpServerErrorException : " + ex.getMessage());
		return new ArrayList<User>();
	}	
	
	public User createUser(User user) {
		
		String createUsersUrl = props.getApiUrl() + "/user";
		
		HttpEntity<User> requestEntity = new HttpEntity<User>(user);
		ResponseEntity<User> response = restTemplate.exchange(
				createUsersUrl, 
				HttpMethod.POST, 
				requestEntity, 
				User.class);
		
		return response.getBody();
	}
	
	public void deleteUser(Integer id) {
		
		String deleteUsersUrl = props.getApiUrl() + "/user/" + id;
		
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUsersUrl, 
				HttpMethod.DELETE,
				null,
				Void.class);
		
		System.out.println(response.getStatusCode().toString());		
	}
	
	public User updateUser(User user) {
		
		String updateUsersUrl = props.getApiUrl() + "/user/" + user.getId();
		
		HttpEntity<User> requestEntity = new HttpEntity<User>(user);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUsersUrl, 
				HttpMethod.PUT, 
				requestEntity, 
				User.class);
		
		return response.getBody();
	}

}

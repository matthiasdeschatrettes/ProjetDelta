package ynov.projetdelta.WebClient.repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ynov.projetdelta.WebClient.model.Com;

@Repository
public class ComProxy extends GenericProxy {
	
	public Com getCom(int id) {
		
		String getComUrl = props.getApiUrl() + "/commentaire/" + id;
		ResponseEntity<Com> response = restTemplate.exchange(getComUrl, HttpMethod.GET, null, Com.class);
		return response.getBody();
	}

}

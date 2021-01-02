package ynov.projetdelta.ArticleMs.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import ynov.projetdelta.ArticleMs.config.CustomProperties;
import ynov.projetdelta.ArticleMs.model.Com;

@Repository
public class ComProxy {

	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	private CustomProperties props;
	
	public Com getCom(int id) {
		
		String getComUrl = props.getApiUrl() + "/commentaire/" + id;
		ResponseEntity<Com> response = restTemplate.exchange(getComUrl, HttpMethod.GET, null, Com.class);
		return response.getBody();
	}
	
}

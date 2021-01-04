package ynov.projetdelta.WebClient.repositories;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ynov.projetdelta.WebClient.model.Cate;

@Repository
public class CateProxy extends GenericProxy {
	
	public Cate getCate(int id) {
	
		String getCateUrl = props.getApiUrl() + "/categorie/" + id;
		ResponseEntity<Cate> response = restTemplate.exchange(getCateUrl, HttpMethod.GET, null, Cate.class);
		return response.getBody();
	}
	
}

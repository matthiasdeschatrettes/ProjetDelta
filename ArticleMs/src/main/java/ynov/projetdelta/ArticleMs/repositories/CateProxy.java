package ynov.projetdelta.ArticleMs.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import ynov.projetdelta.ArticleMs.config.CustomProperties;
import ynov.projetdelta.ArticleMs.model.Cate;
@Repository
public class CateProxy {
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	private CustomProperties props;
	
	public Cate getCate(int id) {
	
		String getCateUrl = props.getApiUrl() + "/categorie/" + id;
		ResponseEntity<Cate> response = restTemplate.exchange(getCateUrl, HttpMethod.GET, null, Cate.class);
		return response.getBody();
	}
	
}

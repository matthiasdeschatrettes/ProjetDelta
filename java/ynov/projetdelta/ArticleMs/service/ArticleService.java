package ynov.projetdelta.ArticleMs.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ynov.projetdelta.ArticleMs.dto.ArtR;
import ynov.projetdelta.ArticleMs.dto.ArticleTransformer;
import ynov.projetdelta.ArticleMs.model.Article;
import ynov.projetdelta.ArticleMs.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ArticleTransformer articleTransformer;
	
	public ArtR getArticle(int id) {
		
		Article article = articleRepository.findById(id).get();
		ArtR artR = articleTransformer.transform(article);
		return artR;
	}
	
	public Iterable<ArtR> getArticles() {
		
		Iterable<Article> articles = articleRepository.findAll();
		ArrayList<ArtR> artRs = new ArrayList<ArtR>();
		
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article a = iterator.next();
			ArtR artR = articleTransformer.transform(a);
			artRs.add(artR);
		}
		return artRs;
	}
	
}

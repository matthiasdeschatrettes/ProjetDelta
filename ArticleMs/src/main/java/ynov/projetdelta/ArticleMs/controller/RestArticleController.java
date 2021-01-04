package ynov.projetdelta.ArticleMs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetdelta.ArticleMs.dto.ArtR;
import ynov.projetdelta.ArticleMs.model.Article;
import ynov.projetdelta.ArticleMs.model.User;
import ynov.projetdelta.ArticleMs.repositories.ArticleRepository;
import ynov.projetdelta.ArticleMs.repositories.UserProxy;
import ynov.projetdelta.ArticleMs.service.ArticleService;

@RestController
public class RestArticleController {

	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article/{id}")
	public ArtR getArticle(@PathVariable("id") int id) {
		return articleService.getArticle(id);
	}
	
	@GetMapping("/article")
	public Iterable<ArtR> getArticles() {
		return articleService.getArticles();
	}
	
}


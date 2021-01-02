package ynov.projetdelta.CategorieMs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetdelta.CategorieMs.dto.CateR;
import ynov.projetdelta.CategorieMs.model.Categorie;
import ynov.projetdelta.CategorieMs.repositories.CategorieRepository;
import ynov.projetdelta.CategorieMs.service.CategorieService;

@RestController
public class RestCategorieController {

	@Autowired
	private CategorieService categorieService;

	@GetMapping("/categorie/{id}")
	public CateR getCategorie(@PathVariable("id") int id) {
		return categorieService.getCategorie(id);
	}
	
	@GetMapping("/categorie")
	public Iterable<CateR> getCategories() {
		return categorieService.getCategories();
	}
	
}

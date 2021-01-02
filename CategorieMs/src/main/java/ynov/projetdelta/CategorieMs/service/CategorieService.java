package ynov.projetdelta.CategorieMs.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ynov.projetdelta.CategorieMs.dto.CategorieTransformer;
import ynov.projetdelta.CategorieMs.repositories.CategorieRepository;
import ynov.projetdelta.CategorieMs.dto.CateR;
import ynov.projetdelta.CategorieMs.model.Categorie;


@Service
public class CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private CategorieTransformer categorieTransformer;
	
	public CateR getCategorie(int id) {
		
		Categorie categorie = categorieRepository.findById(id).get();
		CateR cateR = categorieTransformer.transform(categorie);
		return cateR;
	}
	
	public Iterable<CateR> getCategories() {
		
		Iterable<Categorie> categories = categorieRepository.findAll();
		ArrayList<CateR> cateRs = new ArrayList<CateR>();
		
		Iterator<Categorie> iterator = categories.iterator();
		while(iterator.hasNext()) {
			Categorie C = iterator.next();
			CateR cateR = categorieTransformer.transform(C);
			cateRs.add(cateR);
		}
		return cateRs;
	}
	
}

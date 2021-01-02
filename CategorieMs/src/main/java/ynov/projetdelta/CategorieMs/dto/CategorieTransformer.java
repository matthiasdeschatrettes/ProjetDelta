package ynov.projetdelta.CategorieMs.dto;

import org.springframework.stereotype.Component;

import ynov.projetdelta.CategorieMs.model.Categorie;

@Component
public class CategorieTransformer {

	public CateR transform(Categorie C) {
		
		CateR cateR = new CateR();
		cateR.setId(C.getId());
		cateR.setNom(C.getNom());
		
		return cateR;
	}
	
}

package ynov.projetdelta.CategorieMs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetdelta.CategorieMs.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
	
}

package ynov.projetdelta.CommentaireMs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetdelta.CommentaireMs.model.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer> {

}

package ynov.projetdelta.CommentaireMs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ynov.projetdelta.CommentaireMs.dto.CommentR;
import ynov.projetdelta.CommentaireMs.model.Commentaire;
import ynov.projetdelta.CommentaireMs.model.User;
import ynov.projetdelta.CommentaireMs.repositories.CommentaireRepository;
import ynov.projetdelta.CommentaireMs.repositories.UserProxy;
import ynov.projetdelta.CommentaireMs.service.CommentaireService;

@RestController
public class RestCommentaireController {

	@Autowired
	private CommentaireService commentaireService;
	
	@GetMapping("/commentaire/{id}")
	public CommentR getCommentaire(@PathVariable("id") int id) {
		return commentaireService.getCommentaire(id);
	}
	
	@GetMapping("/commentaire")
	public Iterable<CommentR> getCommentaires() {
		return commentaireService.getCommentaires();
	}
	
}

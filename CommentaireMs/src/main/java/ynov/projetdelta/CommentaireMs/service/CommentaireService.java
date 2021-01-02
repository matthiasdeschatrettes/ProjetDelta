package ynov.projetdelta.CommentaireMs.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ynov.projetdelta.CommentaireMs.dto.CommentR;
import ynov.projetdelta.CommentaireMs.dto.CommentaireTransformer;
import ynov.projetdelta.CommentaireMs.model.Commentaire;
import ynov.projetdelta.CommentaireMs.repositories.CommentaireRepository;

@Service
public class CommentaireService {

	@Autowired
	private CommentaireRepository commentaireRepository;
	
	@Autowired
	private CommentaireTransformer commentaireTransformer;
	
	public CommentR getCommentaire(int id) {
		
		Commentaire commentaire = commentaireRepository.findById(id).get();
		CommentR commentR = commentaireTransformer.transform(commentaire);
		return commentR;
	}
	
	public Iterable<CommentR> getCommentaires() {
		
		Iterable<Commentaire> commentaires = commentaireRepository.findAll();
		ArrayList<CommentR> commentRs = new ArrayList<CommentR>();
		
		Iterator<Commentaire> iterator = commentaires.iterator();
		while(iterator.hasNext()) {
			Commentaire c = iterator.next();
			CommentR commentR = commentaireTransformer.transform(c);
			commentRs.add(commentR);
		}
		return commentRs;
	}
	
}

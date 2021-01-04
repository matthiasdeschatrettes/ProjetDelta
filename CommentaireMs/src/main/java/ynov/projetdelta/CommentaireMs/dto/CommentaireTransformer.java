package ynov.projetdelta.CommentaireMs.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ynov.projetdelta.CommentaireMs.model.Commentaire;
import ynov.projetdelta.CommentaireMs.model.User;
import ynov.projetdelta.CommentaireMs.repositories.UserProxy;

@Component
public class CommentaireTransformer {

	@Autowired
	private UserProxy userProxy;
	
	public CommentR transform(Commentaire c) {
		
		CommentR commentR = new CommentR();
		commentR.setId(c.getId());
		commentR.setDate(c.getDate());
		commentR.setText(c.getText());
		User user = userProxy.getUser(c.getIduser());
		commentR.setUser(user);
		
		return commentR;
	}
}

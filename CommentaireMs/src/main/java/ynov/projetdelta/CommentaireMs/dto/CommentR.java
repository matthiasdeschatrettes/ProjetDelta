package ynov.projetdelta.CommentaireMs.dto;

import ynov.projetdelta.CommentaireMs.model.User;

public class CommentR {

	private int id;
	
	private String text;
	
	private int date;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

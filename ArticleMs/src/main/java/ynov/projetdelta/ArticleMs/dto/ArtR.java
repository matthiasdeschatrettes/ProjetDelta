package ynov.projetdelta.ArticleMs.dto;

import ynov.projetdelta.ArticleMs.model.Cate;
import ynov.projetdelta.ArticleMs.model.Com;
import ynov.projetdelta.ArticleMs.model.User;

public class ArtR {
	
	private int id;
	
	private User user;
	
	private String contenu;
	
	private int date;
	
	private Cate cate;
	
	private Com com;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Cate getCate() {
		return cate;
	}

	public void setCate(Cate cate) {
		this.cate = cate;
	}

	public Com getCom() {
		return com;
	}

	public void setCom(Com com) {
		this.com = com;
	}



}

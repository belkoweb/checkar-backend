package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favoris {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Tapis tapis;
	@ManyToOne
	private User user;
	public Favoris(Long id, Tapis tapis, User user) {
		super();
		this.id = id;
		this.tapis = tapis;
		this.user = user;
	}
	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tapis getTapis() {
		return tapis;
	}
	public void setTapis(Tapis tapis) {
		this.tapis = tapis;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

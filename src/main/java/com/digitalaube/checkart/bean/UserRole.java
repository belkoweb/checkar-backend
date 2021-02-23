package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Rolev role;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(Long id, User user, Rolev role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Rolev getRole() {
		return role;
	}
	public void setRole(Rolev role) {
		this.role = role;
	}
	
	
}

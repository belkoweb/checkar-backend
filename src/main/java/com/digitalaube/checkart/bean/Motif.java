package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Motif {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String symbole;
	private String signification;
	public Motif(Long id, String signe, String signification) {
		super();
		this.id = id;
		this.symbole = signe;
		this.signification = signification;
	}
	public Motif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getSignification() {
		return signification;
	}
	public void setSignification(String signification) {
		this.signification = signification;
	}
	public String getSymbole() {
		return symbole;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	
	
}

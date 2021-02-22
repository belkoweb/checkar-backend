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
	private String signe;
	private String signification;
	public Motif(Long id, String signe, String signification) {
		super();
		this.id = id;
		this.signe = signe;
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
	public String getSigne() {
		return signe;
	}
	public void setSigne(String signe) {
		this.signe = signe;
	}
	public String getSignification() {
		return signification;
	}
	public void setSignification(String signification) {
		this.signification = signification;
	}
	
	
}

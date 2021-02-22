package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TapisOrigine {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Tapis tapis;
	@ManyToOne
	private Origine origine;
	public TapisOrigine(Long id, Tapis tapis, Origine origine) {
		super();
		this.id = id;
		this.tapis = tapis;
		this.origine = origine;
	}
	public TapisOrigine() {
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
	public Origine getOrigine() {
		return origine;
	}
	public void setOrigine(Origine origine) {
		this.origine = origine;
	}
	
}

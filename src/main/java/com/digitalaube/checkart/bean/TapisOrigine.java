package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class TapisOrigine {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)	
	private Tapis tapis;
	@ManyToOne
	private Origine origine;
	public TapisOrigine( Tapis tapis, Origine origine) {
		super();
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

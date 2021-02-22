package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TapisMotif {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Tapis tapis;
	@ManyToOne
	private Motif motif;
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
	public Motif getMotif() {
		return motif;
	}
	public void setMotif(Motif motif) {
		this.motif = motif;
	}
	public TapisMotif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TapisMotif(Long id, Tapis tapis, Motif motif) {
		super();
		this.id = id;
		this.tapis = tapis;
		this.motif = motif;
	}
	
}

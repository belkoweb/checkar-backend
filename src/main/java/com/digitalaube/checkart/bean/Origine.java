package com.digitalaube.checkart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Origine {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String region;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getregion() {
		return region;
	}
	public void setregion(String region) {
		this.region = region;
	}
	public Origine(Long id, String region, Tapis tapis) {
		super();
		this.id = id;
		this.region = region;
	
	}
	public Origine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


package com.digitalaube.checkart.bean;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Tapis {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private float taille;
	private String couleur;
	@OneToMany(mappedBy = "tapis")
	private List<TapisOrigine> tapis_origines;
	@OneToMany(mappedBy = "tapis")
	private List<TapisMotif> tapis_motifs;
	private int w1;
	private int w2;
	private int w3;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] photo;
	private String uri;
	public Tapis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tapis( String nom, String description, float taille, String couleur) {
		super();
		this.nom = nom;
		this.description = description;
		this.taille = taille;
		this.couleur = couleur;
	}
	public Tapis(Long id, String nom, String description, float taille, String couleur, int w1, int w2, int w3,
			byte[] photo, String uri) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.taille = taille;
		this.couleur = couleur;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.photo = photo;
		this.uri = uri;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getW1() {
		return w1;
	}
	public void setW1(int w1) {
		this.w1 = w1;
	}
	public int getW2() {
		return w2;
	}
	public void setW2(int w2) {
		this.w2 = w2;
	}
	public int getW3() {
		return w3;
	}
	public void setW3(int w3) {
		this.w3 = w3;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	
	
	
}

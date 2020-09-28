package org.mongodb.employe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Employe")
public class Employe {
	
	@Id
	private int id;
	private String nom;
	private double salaire;
	
	
	@DBRef
    private List<Societe> societes_ids;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Employe(int id, String nom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.salaire = salaire;
	}
	public Employe() {
		super();
	}
	public List<Societe> getSocietes_ids() {
		return societes_ids;
	}
	public void setSocietes_ids(List<Societe> societes_ids) {
		this.societes_ids = societes_ids;
	}
	
	
	
	

}

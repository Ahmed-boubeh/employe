package org.mongodb.employe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Societe")
public class Societe {
	
	@Id
	private int id;
	private String nom;
	private double adresse;
	
	@DBRef
    private List<Employe> employes_ids;

	public Societe(int id, String nom, double adresse, List<Employe> employes_ids) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.employes_ids = employes_ids;
	}

	public Societe() {
		super();
	}

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

	public double getAdresse() {
		return adresse;
	}

	public void setAdresse(double adresse) {
		this.adresse = adresse;
	}

	public List<Employe> getEmployes_ids() {
		return employes_ids;
	}

	public void setEmployes_ids(List<Employe> employes_ids) {
		this.employes_ids = employes_ids;
	}
	
	
	
}

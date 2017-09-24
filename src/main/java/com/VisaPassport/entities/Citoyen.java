package com.VisaPassport.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Citoyen implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private Date naissance;
	private String email;
	private String photo;
	@OneToMany(mappedBy="citoyen", fetch=FetchType.LAZY)
	private Collection<DemandeVisa> listeDemandes;
	
	public Citoyen() {
		super();
	}

	public Citoyen(String nom, Date naissance, String email, String photo) {
		this.nom = nom;
		this.naissance = naissance;
		this.email = email;
		this.photo = photo;
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

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Collection<DemandeVisa> getListeDemandes() {
		return listeDemandes;
	}

	public void setListeDemandes(Collection<DemandeVisa> listeDemandes) {
		this.listeDemandes = listeDemandes;
	}
}

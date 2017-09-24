package com.VisaPassport.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_demande", discriminatorType=DiscriminatorType.STRING, length=20)
public abstract class DemandeVisa implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private Date dateDemande;
	private int duree;
	private double montant;
	private boolean accorde;
	@ManyToOne
	@JoinColumn(name="ID_CITOYEN")
	private Citoyen citoyen;
	
	public DemandeVisa() {
		super();
	}

	public DemandeVisa(Date dateDemande, int duree, double montant, boolean accorde, Citoyen citoyen) {
		this.dateDemande = dateDemande;
		this.duree = duree;
		this.montant = montant;
		this.accorde = accorde;
		this.citoyen = citoyen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public boolean isAccorde() {
		return accorde;
	}

	public void setAccorde(boolean accorde) {
		this.accorde = accorde;
	}

	public Citoyen getCitoyen() {
		return citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
}

package com.VisaPassport.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("visa_etudiant")
public class DemandeVisaEtudiant extends DemandeVisa {
	private String nomEtablissement;
	private String adressEtablissement;
	
	public DemandeVisaEtudiant() {
		super();
	}

	public DemandeVisaEtudiant(Date dateDemande, int duree, double montant, boolean accorde, Citoyen citoyen, String nomEtablissement, String adressEtablissement) {
		super(dateDemande, duree, montant, accorde, citoyen);
		this.nomEtablissement = nomEtablissement;
		this.adressEtablissement = adressEtablissement;
	}

	public String getNomEtablissement() {
		return nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public String getAdressEtablissement() {
		return adressEtablissement;
	}

	public void setAdressEtablissement(String adressEtablissement) {
		this.adressEtablissement = adressEtablissement;
	}
}

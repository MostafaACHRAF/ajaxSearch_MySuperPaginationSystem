package com.VisaPassport.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("visa_touristique")
public class DemandeVisaTouristique extends DemandeVisa {
	private String nomHotel;
	private String adresseHotel;
	
	public DemandeVisaTouristique() {
		super();
	}

	public DemandeVisaTouristique(Date dateDemande, int duree, double montant, boolean accorde, Citoyen citoyen, String nomHotel, String adresseHotel) {
		super(dateDemande, duree, montant, accorde, citoyen);
		this.nomHotel = nomHotel;
		this.adresseHotel = adresseHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public String getAdresseHotel() {
		return adresseHotel;
	}

	public void setAdresseHotel(String adresseHotel) {
		this.adresseHotel = adresseHotel;
	}
}

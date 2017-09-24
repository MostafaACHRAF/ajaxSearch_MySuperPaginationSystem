package com.VisaPassport.metier;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.VisaPassport.entities.Citoyen;
import com.VisaPassport.entities.DemandeVisa;

public interface IVisaPassportMetier {
	public Page<Citoyen> getAllCitoyens(int page, int size);
	public Page<DemandeVisa> getAllDemandesVisa(int page, int size);
	public Collection<DemandeVisa> getCitoyenDemandesVisa(int id_citoyen);
	public Citoyen getCiotyenById(int id_citoyen);
	public DemandeVisa getDemandeVisaById(int id_demande);
	/*gestion des citoyens :*/
	public Citoyen ajouterCitoyen(Citoyen c);
	public Citoyen modifierCitoyen(Citoyen c);
	public int deleteCitoyen(int id_citoyen);
	/*gestion des demandes de visa*/
	public DemandeVisa ajouterDemandeVisa(DemandeVisa d);
	public DemandeVisa modifierDemandeVisa(DemandeVisa d);
	public int supprimerDemandeVisa(int id_demande);
	public void accepterDemandeVisa(int id_demande);
	public void refuserDemandeVisa(int id_demande);
	public double calculerMontantDemandeVisa(String type, int duree);
	public int[] getPaginationPages (int pages[], int pas, int numPage);
	public Page<DemandeVisa> getDemandesVisaByCitoyenName (String nom, int page, int size);
}

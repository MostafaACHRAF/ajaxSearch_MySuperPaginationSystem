package com.VisaPassport.metier;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.VisaPassport.dao.CitoyenRepository;
import com.VisaPassport.dao.DemandeVisaRepository;
import com.VisaPassport.entities.Citoyen;
import com.VisaPassport.entities.DemandeVisa;
import com.VisaPassport.entities.DemandeVisaEtudiant;
import com.VisaPassport.entities.DemandeVisaTouristique;
import com.VisaPassport.entities.Pagination_v1;
import com.VisaPassport.entities.Pagination_v2;

@Service
@Transactional
public class VisaPassportMetierImpl implements IVisaPassportMetier {
	
	@Autowired
	private CitoyenRepository citoyenRepository;
	@Autowired
	private DemandeVisaRepository demandeVisaRepository;
	private Pagination pagination = new Pagination_v2(); //ma meilleur version de pagination ^_^

	@Override
	public Page<Citoyen> getAllCitoyens(int page, int size) {
		return citoyenRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<DemandeVisa> getAllDemandesVisa(int page, int size) {
		return demandeVisaRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Collection<DemandeVisa> getCitoyenDemandesVisa(int id_citoyen) {
		Citoyen c = getCiotyenById(id_citoyen);
		return c.getListeDemandes();
	}

	@Override
	public Citoyen getCiotyenById(int id_citoyen) {
		Citoyen c = citoyenRepository.findOne(id_citoyen);
		
		if ( c == null) {
			throw new RuntimeException("Erreur ! citoyen introuvable.");
		}
		return c;
	}

	@Override
	public DemandeVisa getDemandeVisaById(int id_demande) {
		DemandeVisa d = demandeVisaRepository.findOne(id_demande);
		
		if (d == null) {
			throw new RuntimeException("Erreur ! demande introuvable.");
		}
		return d;
	}

	@Override
	public Citoyen ajouterCitoyen(Citoyen c) {
		return citoyenRepository.save(c);
	}

	@Override
	public Citoyen modifierCitoyen(Citoyen c) {
		citoyenRepository.updateCitoyen(c.getId(), c.getNom(), c.getNaissance(), c.getEmail(), c.getPhoto());
		return citoyenRepository.findOne(c.getId());
	}

	@Override
	public int deleteCitoyen(int id_citoyen) {
		citoyenRepository.delete(id_citoyen);
		return id_citoyen;
	}

	@Override
	public DemandeVisa ajouterDemandeVisa(DemandeVisa d) {
		d.setMontant(calculerMontantDemandeVisa(d.getClass().getSimpleName(), d.getDuree()));
		return demandeVisaRepository.save(d);
	}

	@Override
	public DemandeVisa modifierDemandeVisa(DemandeVisa d) {
		if (d instanceof DemandeVisaEtudiant) {
			demandeVisaRepository.updateDemandeVisaEtudiant(d.getId(), d.getDuree(), d.getMontant(), ((DemandeVisaEtudiant) d).getNomEtablissement(), ((DemandeVisaEtudiant) d).getAdressEtablissement());
		} else {
			demandeVisaRepository.updateDemandeVisaTouristique(d.getId(), d.getDuree(), d.getMontant(), ((DemandeVisaTouristique) d).getNomHotel(), ((DemandeVisaTouristique) d).getAdresseHotel());
		}
		return demandeVisaRepository.findOne(d.getId());
	}

	@Override
	public int supprimerDemandeVisa(int id_demande) {
		demandeVisaRepository.delete(id_demande);
		return id_demande;
	}

	@Override
	public void accepterDemandeVisa(int id_demande) {
		getDemandeVisaById(id_demande).setAccorde(true);
		demandeVisaRepository.changeEtatOfDemandeVisa(id_demande, true);
	}

	@Override
	public void refuserDemandeVisa(int id_demande) {
		getDemandeVisaById(id_demande).setAccorde(false);
		demandeVisaRepository.changeEtatOfDemandeVisa(id_demande, false);
	}

	@Override
	public double calculerMontantDemandeVisa(String type, int duree) {
		double tarif;
		if (type.equals("DemandeVisaEtudiant")) {
			tarif = 500;
		} else {
			tarif = 1000;
		}
		return tarif * duree;
	}

	@Override
	public int[] getPaginationPages(int[] pages, int pas, int numPage) {
		return pagination.getPaginationPages(pages, pas, numPage);
	}

	@Override
	public Page<DemandeVisa> getDemandesVisaByCitoyenName(String nom, int page, int size) {
		return demandeVisaRepository.getDemandesVisaByCitoyenName(nom, new PageRequest(page, size));
	}
}

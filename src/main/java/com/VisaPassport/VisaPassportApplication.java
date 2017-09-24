package com.VisaPassport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VisaPassport.dao.CitoyenRepository;
import com.VisaPassport.dao.DemandeVisaRepository;
import com.VisaPassport.entities.Citoyen;
import com.VisaPassport.entities.DemandeVisa;
import com.VisaPassport.entities.DemandeVisaEtudiant;
import com.VisaPassport.metier.IVisaPassportMetier;

@SpringBootApplication
public class VisaPassportApplication implements CommandLineRunner {
	
	@Autowired
	private CitoyenRepository citoyenRepository;
	@Autowired
	private DemandeVisaRepository demandeVisaRepository;
	@Autowired
	private IVisaPassportMetier visaPassportMetier;

	public static void main(String[] args) {
		SpringApplication.run(VisaPassportApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*teste couche metier*/
		Citoyen c1 = citoyenRepository.save(new Citoyen("mostafa", new Date(), "mostafaegma@gmail.com", "lien1"));
		Citoyen c2 = citoyenRepository.save(new Citoyen("achraf", new Date(), "achraf@gmail.com", "lien3"));
		Citoyen c3 = citoyenRepository.save(new Citoyen("rahaf", new Date(), "rahaf@gmail.com", "lien2"));
		Citoyen c4 = citoyenRepository.save(new Citoyen("naida", new Date(), "nadia@gmail.com", "lien2"));
		Citoyen c5 = citoyenRepository.save(new Citoyen("salma", new Date(), "salma@gmail.com", "lien2"));
		Citoyen c6 = citoyenRepository.save(new Citoyen("omima", new Date(), "omima@gmail.com", "lien2"));
		Citoyen c7 = citoyenRepository.save(new Citoyen("ba", new Date(), "ba@gmail.com", "lien2"));
		Citoyen c8 = citoyenRepository.save(new Citoyen("hicham", new Date(), "hicham@gmail.com", "lien2"));
		Citoyen c9 = citoyenRepository.save(new Citoyen("yassmina", new Date(), "yassmina@gmail.com", "lien2"));
		Citoyen c10 = citoyenRepository.save(new Citoyen("aya", new Date(), "aya@gmail.com", "lien2"));
		Citoyen c11 = citoyenRepository.save(new Citoyen("rahaf", new Date(), "abdo@gmail.com", "lien2"));
		
		/*System.out.println("Liste des demandes :");
		for (Citoyen c : citoyenRepository.findAll()) {
			System.out.println(c.getNom());
		}*/
		
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 7, 1520, true, c1, "enset", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 8, 1520, true, c2, "fst", "settat"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 15, 1520, false, c3, "ena", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 17, 1520, true, c3, "emi", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 10, 1520, false, c11, "ensa", "hoceima"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 3, 1520, false, c4, "encg", "marrakech"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 7, 1520, false, c5, "est", "casablanca"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 28, 1520, true, c6, "est", "fes"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 50, 1520, false, c7, "istah", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 7, 1520, true, c8, "enset", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 8, 1520, true, c9, "fst", "settat"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 15, 1520, false, c10, "ena", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 17, 1520, true, c6, "emi", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 10, 1520, false, c8, "ensa", "hoceima"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 3, 1520, false, c9, "encg", "marrakech"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 7, 1520, false, c10, "est", "casablanca"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 28, 1520, true, c11, "est", "fes"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 50, 1520, false, c2, "istah", "mohammedia"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 5, 1520, true, c1, "tata", "tata"));
		demandeVisaRepository.save(new DemandeVisaEtudiant(new Date(), 5, 1520, true, c3, "tata", "tata"));
		
		/*System.out.println("Liste des demandes :");
		for (DemandeVisa d : demandeVisaRepository.findAll()) {
			System.out.println(d.getId() + " *** " + d.getMontant());
		}*/
		
		/*teste update delete des demandes*/
		/*System.out.println("Modifier le montant de la premiere demande :");
		DemandeVisa d = visaPassportMetier.getDemandeVisaById(1);
		d.setMontant(5200.230);*/
		//visaPassportMetier.modifierDemandeVisa(d);
		/*System.out.println("Supprimer la deuxieme demande :");*/
		//demandeVisaRepository.delete(2);
		
		/*System.out.println("Accepter la troisieme demande :");
		visaPassportMetier.accepterDemandeVisa(3);*/
	}
}

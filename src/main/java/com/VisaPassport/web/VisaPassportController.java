package com.VisaPassport.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VisaPassport.entities.Citoyen;
import com.VisaPassport.entities.DemandeVisa;
import com.VisaPassport.metier.VisaPassportMetierImpl;

@Controller
public class VisaPassportController {
	@Autowired
	private VisaPassportMetierImpl visaPassportMetier;
	
	@RequestMapping("/consulterDemandesVisa")
	public String consulterDemandesVisa (Model model, @RequestParam(name="page", defaultValue="0")int p, @RequestParam(name="size", defaultValue="3")int s) {
		Page<DemandeVisa> demandesVisa = visaPassportMetier.getAllDemandesVisa(p, s);
		int[]pages = new int [demandesVisa.getTotalPages()];
		int subPages[] = visaPassportMetier.getPaginationPages(pages, 5, p);
		
		model.addAttribute("pages", subPages);
		model.addAttribute("taille", pages.length);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("listeDemandesVisa", demandesVisa.getContent());
		
		return "demandesVisa";
	}
	
	@RequestMapping("/consulterCitoyens")
	public String consulterCitoyens (Model model, @RequestParam(name="page", defaultValue="0")int p, @RequestParam(name="size", defaultValue="3")int s) {
		Page<Citoyen> citoyens = visaPassportMetier.getAllCitoyens(p, s);
		int[] pages = new int [citoyens.getTotalPages()];
		
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("listeCitoyens", citoyens.getContent());
		
		return "citoyens";
	}
	
	@RequestMapping("/consulterSesDemandesVisa")
	public String consulterSesDemandesVisa (Model model, int id_citoyen, @RequestParam(name="page", defaultValue="0")int p, @RequestParam(name="size", defaultValue="3")int s) {
		model.addAttribute("sesDemandesVisa", visaPassportMetier.getCitoyenDemandesVisa(id_citoyen));
		return "sesDemandesVisa";
	}
	
	@RequestMapping("/chercherDemandeVisa")
	public String chercherDemandeVisa (Model model, String info, @RequestParam(name="page", defaultValue="0")int p, @RequestParam(name="size", defaultValue="3")int s) {
		if (info instanceof String) {
			//chercher les demandes par citoyen :
			Page<DemandeVisa> demandesVisa = visaPassportMetier.getDemandesVisaByCitoyenName(info, p, s);
			int[] pages = new int [demandesVisa.getTotalPages()];
			int subPages[] = visaPassportMetier.getPaginationPages(pages, 5, p);
			
			model.addAttribute("pages", subPages);
			model.addAttribute("taille", pages.length);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("listeDemandesVisa", demandesVisa.getContent());
		} else {
			//chercher les demandes par id_demande :
		}
		return "demandesVisa";
	}
}

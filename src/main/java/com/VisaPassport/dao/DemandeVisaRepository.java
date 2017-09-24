package com.VisaPassport.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.VisaPassport.entities.DemandeVisa;

public interface DemandeVisaRepository extends JpaRepository<DemandeVisa, Integer> {
	@Query("select d from DemandeVisa d order by d.dateDemande desc")
	public Page<DemandeVisa> findAll(Pageable pageable);
	
	@Modifying
	@Query("update DemandeVisa d set d.accorde=:accorde where d.id=:id")
	public void changeEtatOfDemandeVisa(@Param("id")int id, @Param("accorde")boolean accorde);
	
	@Modifying
	@Query("update DemandeVisaEtudiant de set de.duree = :duree, de.montant = :montant, de.nomEtablissement = :nomE, de.adressEtablissement = :adressE where de.id = :id")
	public void updateDemandeVisaEtudiant(@Param("id")int id, @Param("duree")int duree, @Param("montant")double montant, @Param("nomE")String nomE, @Param("adressE")String adressE);
	
	@Modifying
	@Query("update DemandeVisaTouristique dt set dt.duree = :duree, dt.montant = :montant, dt.nomHotel = :nomH, dt.adresseHotel = :adressH where dt.id = :id")
	public void updateDemandeVisaTouristique(@Param("id")int id, @Param("duree")int duree, @Param("montant")double montant, @Param("nomH")String nomH, @Param("adressH")String adressH);
	
	
	@Query("select d from DemandeVisa d where d.citoyen.nom like %:nom%")
	public Page<DemandeVisa> getDemandesVisaByCitoyenName (@Param("nom")String nom, Pageable pageable);
}
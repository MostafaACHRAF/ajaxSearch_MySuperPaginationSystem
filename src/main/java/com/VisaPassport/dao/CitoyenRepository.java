package com.VisaPassport.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.VisaPassport.entities.Citoyen;

public interface CitoyenRepository extends JpaRepository<Citoyen, Integer>{
	@Query("select c from Citoyen c order by c.id")
	public Page<Citoyen> findAll(Pageable pageable);
	
	@Modifying
	@Query("update Citoyen c set nom = :nom, naissance = :naissance, email = :email, photo = :photo where id = :id")
	public void updateCitoyen(@Param("id")int id_citoyen, @Param("nom")String nom, @Param("naissance")Date naissance, @Param("email")String email, @Param("photo")String photo);
}

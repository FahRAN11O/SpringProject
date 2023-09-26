package com.springprj.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springprj.project.models.ClientEntity;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
	
	ClientEntity findByNom(String nom);
	
}

package com.springprj.project.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.springprj.project.dto.ClientRequestDto;
import com.springprj.project.dto.ClientResponseDto;
import com.springprj.project.models.ClientEntity;

public interface ClientService {
	ClientResponseDto save(ClientRequestDto clientRequestDto);
	ClientResponseDto findById(Integer id);
	
	ClientResponseDto findByNom(String nom);
	
	void delete(Integer id);
	
	ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException;
	
	List<ClientResponseDto> findAll();
}

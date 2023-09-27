package com.springprj.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springprj.project.dao.ClientDao;
import com.springprj.project.dto.ClientRequestDto;
import com.springprj.project.dto.ClientResponseDto;
import com.springprj.project.models.ClientEntity;

@Service("impl1")
public class ClientServiceImpl implements ClientService{
	private ClientDao clientDao;
	private ModelMapper modelMapper;
	
	public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
		this.clientDao = clientDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ClientResponseDto save(ClientRequestDto clientRequestDto) {
		ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
		ClientEntity saved = clientDao.save(clientEntity);
		return modelMapper.map(saved, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new RuntimeException("Client Not Found"));
		return modelMapper.map(clientEntity, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findByNom(String nom) {
		ClientEntity clientEntity = clientDao.findByNom(nom);
		return modelMapper.map(clientEntity, ClientResponseDto.class);
		
	}
	
	
	@Override
	public void delete(Integer id) {
		clientDao.deleteById(id);
		
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.springprj.project.service;

import org.springframework.stereotype.Service;

import com.springprj.project.dto.ClientRequestDto;
import com.springprj.project.dto.ClientResponseDto;

@Service("impl2")
public class ClientServiceImpl2 implements ClientService{

	@Override
	public ClientRequestDto save(ClientRequestDto clientRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientResponseDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

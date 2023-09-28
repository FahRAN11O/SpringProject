package com.springprj.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
		Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
		if(clientEntityOptional.isPresent()) {
			ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
			clientEntity.setId(id);
			ClientEntity update =  clientDao.save(clientEntity);
			return modelMapper.map(update, ClientResponseDto.class);
		}else {
			throw new NotFoundException();
		}
		return null;
	}

	@Override
	public List<ClientResponseDto> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll()
				.stream().map(el ->modelMapper.map(el, ClientResponseDto.class)).collect(Collectors.toList());
	}

}

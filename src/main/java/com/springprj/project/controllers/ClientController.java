package com.springprj.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprj.project.dto.ClientRequestDto;
import com.springprj.project.dto.ClientResponseDto;
import com.springprj.project.service.ClientService;

@RestController
@RequestMapping
public class ClientController {
	
	@Autowired /*peut avoir plusieurs implementations ?*/
	@Qualifier("impl2")
	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping
	public List<ClientResponseDto> getClient() {
		return clientService.findAll();
	}
	
	@PostMapping("")
	public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
		return clientService.save(clientRequestDto);
	}
}

package com.springprj.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprj.project.service.ClientService;

@RestController
@RequestMapping
public class ClientController {
	
	@Autowired /*peut avoir plusieurs implementations ?*/
	@Qualifier("impl2")
	private ClientService clientService;
}

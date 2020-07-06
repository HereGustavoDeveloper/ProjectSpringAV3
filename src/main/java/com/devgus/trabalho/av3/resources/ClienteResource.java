package com.devgus.trabalho.av3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgus.trabalho.av3.domain.Cliente;
import com.devgus.trabalho.av3.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;
 
 

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService  service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Cliente> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		 Cliente obj = service.find(id);
	     return ResponseEntity.ok().body(obj);
	}
}

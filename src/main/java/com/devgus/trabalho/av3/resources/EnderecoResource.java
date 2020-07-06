package com.devgus.trabalho.av3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgus.trabalho.av3.domain.Endereco;
import com.devgus.trabalho.av3.services.EnderecoService;

import javassist.tools.rmi.ObjectNotFoundException;
 

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoService  service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Endereco> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		 Endereco obj = service.find(id);
		 
	     return ResponseEntity.ok().body(obj);
	}
}

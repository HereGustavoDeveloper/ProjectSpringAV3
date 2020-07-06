package com.devgus.trabalho.av3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgus.trabalho.av3.domain.Cartao;
import com.devgus.trabalho.av3.services.CartaoService;

import javassist.tools.rmi.ObjectNotFoundException;
 
 
@RestController
@RequestMapping(value = "/cartao")
public class CartaoResource {

	@Autowired
	private CartaoService  service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Cartao> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		 Cartao obj = service.find(id);
		 
	     return ResponseEntity.ok().body(obj);
	}
	
}

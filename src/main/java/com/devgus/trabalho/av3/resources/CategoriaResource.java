package com.devgus.trabalho.av3.resources;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgus.trabalho.av3.domain.Categoria;
import com.devgus.trabalho.av3.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService  service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		 Categoria obj = service.find(id);
		 
	     return ResponseEntity.ok().body(obj);
	}
	
}

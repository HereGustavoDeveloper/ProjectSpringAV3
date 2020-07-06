package com.devgus.trabalho.av3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgus.trabalho.av3.domain.Categoria;
import com.devgus.trabalho.av3.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository; 
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
 
		 
		java.util.Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("\n\nObjeto não encontrad ! ID: "+id+ ", Tipo: \n\n"+Categoria.class+"\n\n"));
		
	}

	
}

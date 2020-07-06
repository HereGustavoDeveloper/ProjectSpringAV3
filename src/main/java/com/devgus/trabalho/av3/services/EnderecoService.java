package com.devgus.trabalho.av3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgus.trabalho.av3.domain.Endereco;
import com.devgus.trabalho.av3.repositories.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;
 
@Service
public class EnderecoService { 
	
	// SAO ESSAS  3 DEPENDENCIAS PARA COLOCAR NO PROJETO ! H2 , JPA WEB 
	@Autowired
	private EnderecoRepository repository; 
	
	public Endereco find(Integer id) throws ObjectNotFoundException {
 
		 
		java.util.Optional<Endereco> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("\n\nObjeto não encontrad ! ID: "+id+ ", Tipo: \n\n"+Endereco.class+"\n\n"));
		
	}

}

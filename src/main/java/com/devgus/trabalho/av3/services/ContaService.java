package com.devgus.trabalho.av3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgus.trabalho.av3.domain.Conta;
import com.devgus.trabalho.av3.repositories.ContaRepository;

import javassist.tools.rmi.ObjectNotFoundException;
 

@Service
public class ContaService {
	

	@Autowired
	private ContaRepository repository; 
	
	public Conta find(Integer id) throws ObjectNotFoundException {
 
		 
		java.util.Optional<Conta> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("\n\nObjeto não encontrad ! ID: "+id+ ", Tipo: \n\n"+Conta.class+"\n\n"));
	}

}

package com.devgus.trabalho.av3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgus.trabalho.av3.domain.Fatura;
import com.devgus.trabalho.av3.repositories.FaturaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FaturaService {
	
	@Autowired
	private FaturaRepository repository; 
	
	public Fatura find(Integer id) throws ObjectNotFoundException {
 
		 
		java.util.Optional<Fatura> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("\n\nObjeto não encontrad ! ID: "+id+ ", Tipo: \n\n"+Fatura.class+"\n\n"));
		
	}
}

package com.devgus.trabalho.av3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devgus.trabalho.av3.domain.Cartao;
import com.devgus.trabalho.av3.repositories.CartaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;
 

@Service
public class CartaoService {
	

	@Autowired
	private CartaoRepository repository; 
	
	public Cartao find(Integer id) throws ObjectNotFoundException {
 
		 
		java.util.Optional<Cartao> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("\n\nObjeto não encontrad ! ID: "+id+ ", Tipo: \n\n"+Cartao.class+"\n\n"));
		
	}

}

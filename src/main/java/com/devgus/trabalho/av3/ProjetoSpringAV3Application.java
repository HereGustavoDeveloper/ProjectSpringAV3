package com.devgus.trabalho.av3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devgus.trabalho.av3.domain.Cartao;
import com.devgus.trabalho.av3.domain.Categoria;
import com.devgus.trabalho.av3.domain.Cliente;
import com.devgus.trabalho.av3.domain.Conta;
import com.devgus.trabalho.av3.domain.Endereco;
import com.devgus.trabalho.av3.domain.Fatura;
import com.devgus.trabalho.av3.repositories.CartaoRepository;
import com.devgus.trabalho.av3.repositories.CategoriaRepository;
import com.devgus.trabalho.av3.repositories.ClienteRepository;
import com.devgus.trabalho.av3.repositories.FaturaRepository;

@SpringBootApplication
public class ProjetoSpringAV3Application implements CommandLineRunner{
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	FaturaRepository faturaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	com.devgus.trabalho.av3.repositories.EnderecoRepository enderecoRepository;
	
	@Autowired
	com.devgus.trabalho.av3.repositories.ContaRepository  contaRepository;
	
 	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringAV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
	// ARMAZENANDO DADOS DE CLIENTE E ENDERECO
	Cliente cli1 = new Cliente(null,"carol@gmail.com","CAROL CORDEIRO","(85)9999-999");
	Cliente cli2 = new Cliente(null,"carlos@gmail.com","CARLOS JUNIOR","(85)9999-9999");
	Cliente cli3 = new Cliente(null,"maria@gmail.com","MARIA LIMA","(85)5555-555");
   
	Endereco end1 = new Endereco(null,"Rua: COSTA RIBEIRO","667","CENTRO","FORTALEZA","CE",cli1);	
	Endereco end2 = new Endereco(null,"Rua: FRAGOSO","655","CENTRO","MARACANAU","CE",cli2);	
   	Endereco end3 = new Endereco(null,"Rua: MARTINO","832","CENTRO","HORIZONTE","CE",cli3);	
   
	clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
	enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
   
   	Categoria cat1 = new Categoria(null,"Gold");
   	Categoria cat2 = new Categoria(null,"Bronze");
   	Categoria cat3 = new Categoria(null,"Silver");
   
  
   	SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
	Date dtVenc = dt.parse("20/02/2021");
	
	Cartao card1 = new Cartao(null,26643322,dtVenc,cli1.getNome(),874,"20719");
	Cartao card2 = new Cartao(null,23741322,dt.parse("31/02/2022"),cli2.getNome(),684,"0002");
 	Cartao card3 = new Cartao(null,23349822,dt.parse("31/02/2022"),cli3.getNome(),124,"0232");	
   
 	
   	Conta cnt1 = new Conta(null,458212,new Double (2500),true,cat1,card1);
   	Conta cnt2 = new Conta(null,589636,new Double (10000),true,cat2,card2);
   	Conta cnt3 = new Conta(null,553287,new Double (800000),true,cat3,card3);
   
   	card1.getContas().addAll(Arrays.asList(cnt1));
 	card2.getContas().addAll(Arrays.asList(cnt2));
 	card3.getContas().addAll(Arrays.asList(cnt3));
 	

   	categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
   	
   	cnt1.setCliente(cli1);
   	cnt2.setCliente(cli2);  
   	cnt3.setCliente(cli3);
  
   	cli1.getEnderecos().addAll(Arrays.asList(end1));
   	cli2.getEnderecos().addAll(Arrays.asList(end2));
   	cli3.getEnderecos().addAll(Arrays.asList(end3));
   	 
 	
 	Fatura fat1C1 = new Fatura(dt.parse("15/06/2020"),dt.parse("10/06/2020"),true,new Double(0),new Double(260),card1);
 	Fatura fat2C1 = new Fatura(dt.parse("30/07/2020"),dt.parse("20/07/2020"),true,new Double(0),new Double(1800),card1);
 	Fatura fat3C1 = new Fatura(dt.parse("15/05/2020"),null,false,new Double(0.5),new Double(100),card1);
 	
 	Fatura fat1C2 = new Fatura(dt.parse("02/03/2020"),dt.parse("01/03/2020"),true,new Double(0),new Double(360),card2);
 	Fatura fat2C2 = new Fatura(dt.parse("23/06/2020"),dt.parse("20/06/2020"),true,new Double(0),new Double(560),card2);
 	Fatura fat3C2 = new Fatura(dt.parse("20/04/2020"),dt.parse("22/04/2020"),true,new Double(3.5),new Double(560),card2);
 	
 	Fatura fat1C3 = new Fatura(dt.parse("25/03/2020"),dt.parse("15/03/2020"),true,new Double(0),new Double(460),card3);
 	Fatura fat2C3 = new Fatura(dt.parse("15/05/2020"),dt.parse("10/05/2020"),true,new Double(0),new Double(560),card3);
 	Fatura fat3C3 = new Fatura(dt.parse("01/05/2020"),dt.parse("10/05/2020"),true,new Double(20),new Double(860),card3);
 	
 	card1.getFaturas().addAll(Arrays.asList(fat1C1,fat2C1,fat3C1));
 	card2.getFaturas().addAll(Arrays.asList(fat1C2,fat2C2,fat3C2));
 	card3.getFaturas().addAll(Arrays.asList(fat1C3,fat2C3,fat3C3));
 	  	 
 	cartaoRepository.saveAll(Arrays.asList(card1,card2,card3));
 	faturaRepository.saveAll(Arrays.asList(fat1C1,fat2C1,fat3C1,fat1C2,fat2C2,fat3C2,fat1C3,fat2C3,fat3C3));
 	
 	contaRepository.saveAll(Arrays.asList(cnt1,cnt2,cnt3));
   	
 	 
  }
}

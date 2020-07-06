package com.devgus.trabalho.av3.domain;

import java.io.Serializable;
 
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

@Entity
public class Fatura implements Serializable{
  private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataVencimento;
	private Date dataPagamento;
	private Double juros;
	private Boolean estado;
	private Double total;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cartao_id")
	private Cartao cartao;
	  
	public Fatura (){
		
	}
	
	public Fatura (Date dataVencimento,Date dataPagamento,Boolean estado,Double juros,Double total,Cartao cartao){
		super();

		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.estado = estado;
		this.juros = juros;
		this.total = total;
		this.cartao = cartao;
		 
	}
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Double getJuros() {
		return juros;
	}
	public void setJuros(Double juros) {
		this.juros = juros;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fatura other = (Fatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
 
}

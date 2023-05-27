package br.com.fiapchallenge.model;

import java.sql.Date;

public class RendaMensal {
	private Long Id;
	private double rendaMensal;
	private Date data;
	private String renda;
	private int conta;
	private int usuario;
	
	
	public RendaMensal(Long Id,double rendaMensal, Date data, String renda, int conta, int usuario) {
		this.Id = Id;
		this.rendaMensal = rendaMensal;
		this.data = data;
		this.renda = renda;
		this.conta = conta;
		this.usuario = usuario;
	}

	public RendaMensal(double rendaMensal, Date data,String renda, int conta, int usuario) {
		this(null, rendaMensal, data, renda, conta,usuario);
	}

	public Long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}
	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getRenda() {
		return renda;
	}
	public void setRenda(String renda) {
		this.renda = renda;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	
}

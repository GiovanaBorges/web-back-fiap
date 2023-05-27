package br.com.fiapchallenge.model;

import java.sql.Date;
import java.time.LocalDate;

public class Gastos {
	private Long Id;
	private Date data;
	private String gastos;
	private int conta;
	private int usuario;
	private double valor;
	
	
	public Gastos(Long Id,Date data, String gastos, int conta, int usuario, double valor) {
		this.Id = Id;
		this.data = data;
		this.gastos = gastos;
		this.conta = conta;
		this.usuario = usuario;
		this.valor = valor;
	}

	public Gastos(Date data, String gastos, int conta, int usuario, double valor) {
		this(null, data, gastos, conta, usuario,valor);
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getGastos() {
		return gastos;
	}
	public void setGastos(String gastos) {
		this.gastos = gastos;
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
	public Gastos(int i, LocalDate of, String compraDoMes, int i1, double v) {
		
	}
	
	
}

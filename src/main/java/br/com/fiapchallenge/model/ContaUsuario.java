package br.com.fiapchallenge.model;

import java.sql.Date;

public class ContaUsuario {
	private Long Id;
	private int numero;
	private String agencia;
	private String banco;
	private String usuario;

	public ContaUsuario(int numero, String agencia, String banco, String usuario, Long Id) {
		this.numero = numero;
		this.agencia = agencia;
		this.banco = banco;
		this.usuario = usuario;
		this.Id = Id;
	}

	public ContaUsuario(int numero, String agencia, String banco, String usuario) {
		this(numero, agencia, banco, usuario,null);
	}



	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}



	
}

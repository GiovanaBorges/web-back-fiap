package br.com.fiapchallenge.model;

import java.sql.Date;

public class Usuario {
	private Long id;
	private String usuario;
	private String senha;
	
	public Usuario(Long id, String usuario, String senha) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario( String usuario, String senha) {
		this(null, usuario,senha);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

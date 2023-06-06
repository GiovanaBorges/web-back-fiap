package br.com.fiapchallenge.model;
import java.sql.Date;
public class Despesa {
	private Long Id;
	private double valor_despesa;
	private Date dt_despesa;
	private int id_usuario;

	public Despesa(double valor_despesa, Date dt_despesa, int id_usuario, Long Id) {
		this.valor_despesa = valor_despesa;
		this.dt_despesa = dt_despesa;
		this.id_usuario = id_usuario;
		this.Id = Id;
	}

	public Despesa(double valor_despesa, Date dt_despesa, int id_usuario) {
		this(valor_despesa, dt_despesa, id_usuario,null);
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public double getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(double valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	public Date getDt_despesa() {
		return dt_despesa;
	}

	public void setDt_despesa(Date dt_despesa) {
		this.dt_despesa = dt_despesa;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}

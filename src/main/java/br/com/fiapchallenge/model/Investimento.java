package br.com.fiapchallenge.model;

import java.sql.Date;

public class Investimento {
    private Long Id;
    private double vl_investimento;
    private Date data_inicial;
    private Date data_final;
    private String nm_investimento;
    private String descri_investimento;
    private int usuario;


    public Investimento(Long Id,double vl_investimento, Date data_inicial,Date data_final, String nm_investimento, String descri_investimento, int usuario) {
        this.Id = Id;
        this.vl_investimento = vl_investimento;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.nm_investimento = nm_investimento;
        this.descri_investimento = descri_investimento;
        this.usuario = usuario;
    }

    public Investimento(double vl_investimento, Date data_inicial,Date data_final, String nm_investimento, String descri_investimento, int usuario) {
        this(null, vl_investimento, data_inicial, data_final, nm_investimento,descri_investimento,usuario);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getVl_investimento() {
        return vl_investimento;
    }

    public void setVl_investimento(double vl_investimento) {
        this.vl_investimento = vl_investimento;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public String getNm_investimento() {
        return nm_investimento;
    }

    public void setNm_investimento(String nm_investimento) {
        this.nm_investimento = nm_investimento;
    }

    public String getDescri_investimento() {
        return descri_investimento;
    }

    public void setDescri_investimento(String descri_investimento) {
        this.descri_investimento = descri_investimento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}

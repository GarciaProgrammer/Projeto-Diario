package br.com.projetodiario.bean;

import java.io.Serializable;

public class Nota implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	private int id;
	private String assunto;
	private String dtNota; 
	private String texto;
	
	public Nota () {
		
	}

	public Nota(int id, String assunto, String dtNota, String texto) {
		this.id = id;
		this.assunto = assunto;
		this.dtNota = dtNota;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDtNota() {
		return dtNota;
	}

	public void setDtNota(String dtNota) {
		this.dtNota = dtNota;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}

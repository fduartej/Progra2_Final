package com.example.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tarjeta {
	@GeneratedValue
	@Id
	private Integer id;
	private int idperson; 
	private String numero; 
	private String expiracion; 
	private int codigo; 
	
	public Tarjeta() {
		super();
	}

	public Tarjeta(Integer id, int idperson, String numero, String expiracion, int codigo) {
		super();
		this.id = id;
		this.idperson = idperson;
		this.numero = numero;
		this.expiracion = expiracion;
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdperson() {
		return idperson;
	}

	public void setIdperson(int idperson) {
		this.idperson = idperson;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(String expiracion) {
		this.expiracion = expiracion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", idperson=" + idperson + ", numero=" + numero + ", expiracion=" + expiracion
				+ ", codigo=" + codigo + "]";
	}
	
	

}

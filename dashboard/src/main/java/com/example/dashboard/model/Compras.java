package com.example.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compras {
	@GeneratedValue
	@Id
	private Integer id;
	private int idperson; 
	private int idvehiculo;
	private String fechacompra;
	
	public Compras() {
		super();
	}

	public Compras(Integer id, int idperson, int idvehiculo, String fechacompra) {
		super();
		this.id = id;
		this.idperson = idperson;
		this.idvehiculo = idvehiculo;
		this.fechacompra = fechacompra;
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

	public int getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(int idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(String fechacompra) {
		this.fechacompra = fechacompra;
	}

	
	
}

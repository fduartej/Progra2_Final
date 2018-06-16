package com.example.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vehiculo {
	@GeneratedValue
	@Id
	private Integer id;

	@NotNull
	private int anno; 
	
	@NotNull
	private String marca;
	
	@NotNull
	private String modelo;
	
	@NotNull
	private long precio;
	
	public Vehiculo() {
		
	}

	public Vehiculo(int id, @NotNull int anno, @NotNull String marca, @NotNull String modelo, @NotNull long precio) {
		super();
		this.id = id;
		this.anno = anno;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", anno=" + anno + ", marca=" + marca + ", modelo=" + modelo + ", precio="
				+ precio + "]";
	}
}



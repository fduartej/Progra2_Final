package com.example.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

	@GeneratedValue
	@Id
	private Integer id;

	@NotNull
	@Size(min=2, max=45)
	private String nombre; 
	
	@NotNull
	@Size(min=8, max=8)
	private String dni;
	
	@NotNull
	private String relacionLaboral;
	
	@NotNull
	private double ingresoAnual;
	
	@NotNull
	private double uit;
	
	private double totalImpuesto;
	
	private double totalBruto;
	
	private double totalNeto;
	
	@NotNull
	@Email
	@Size(min=8, max=80)
	private String correo;
	
	public Person() {
		super();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getRelacionLaboral() {
		return relacionLaboral;
	}

	public void setRelacionLaboral(String relacionLaboral) {
		this.relacionLaboral = relacionLaboral;
	}

	public double getIngresoAnual() {
		return ingresoAnual;
	}

	public void setIngresoAnual(double ingresoAnual) {
		this.ingresoAnual = ingresoAnual;
	}

	public double getUit() {
		return uit;
	}

	public void setUit(double uit) {
		this.uit = uit;
	}

	public double getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(double totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	public double getTotalBruto() {
		return totalBruto;
	}

	public void setTotalBruto(double totalBruto) {
		this.totalBruto = totalBruto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public double getTotalNeto() {
		return totalNeto;
	}



	public void setTotalNeto(double totalNeto) {
		this.totalNeto = totalNeto;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", relacionLaboral=" + relacionLaboral
				+ ", ingresoAnual=" + ingresoAnual + ", uit=" + uit + ", totalImpuesto=" + totalImpuesto
				+ ", totalBruto=" + totalBruto + ", totalNeto=" + totalNeto + ", correo=" + correo + "]";
	}
	
	
}

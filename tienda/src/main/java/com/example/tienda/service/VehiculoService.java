package com.example.tienda.service;

import java.util.List;

import com.example.tienda.model.Vehiculo;

public interface VehiculoService {
	public abstract List<Vehiculo> buscarVehiculoXPrecio(double precio);
	public abstract Vehiculo buscarXId(int id);
}

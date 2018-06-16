package com.example.demoBatch.service;

import java.util.List;

import com.example.demoBatch.model.Vehiculo;

public interface VehiculoService {
	public abstract List<Vehiculo> buscarVehiculoXPrecio(String precio);
}

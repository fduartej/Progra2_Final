package com.example.dashboard.service;

import java.util.List;

import com.example.dashboard.model.Vehiculo;
public interface VehiculoService {
	public abstract List<Vehiculo> buscarVehiculoXPrecio(double precio);
	public abstract int contar();
}

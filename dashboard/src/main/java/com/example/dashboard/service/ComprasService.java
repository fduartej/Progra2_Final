package com.example.dashboard.service;

import com.example.dashboard.model.Compras;

public interface ComprasService {
	public abstract Compras save(Compras compras);
	
	public abstract int contar();
}

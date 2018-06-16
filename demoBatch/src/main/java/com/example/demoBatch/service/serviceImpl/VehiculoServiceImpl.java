package com.example.demoBatch.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demoBatch.model.Vehiculo;
import com.example.demoBatch.repository.VehiculoRepository;
import com.example.demoBatch.service.VehiculoService;

@Service("vehiculoServiceImpl")
public class VehiculoServiceImpl implements VehiculoService{
	public static final Log Log = LogFactory.getLog(PersonServiceImpl.class);
	
	@Autowired
	@Qualifier("VehiculoRepository")
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public List<Vehiculo> buscarVehiculoXPrecio(String precio) {
		Log.info("buscarVehiculoXPrecio"+"("+precio+");");
		List<Vehiculo> lista = new ArrayList<>(); 
		lista = (List<Vehiculo>) vehiculoRepository.buscarXPrecio(precio);
		return lista ;
	}	
} 

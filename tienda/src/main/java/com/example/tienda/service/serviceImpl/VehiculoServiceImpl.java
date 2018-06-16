package com.example.tienda.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Vehiculo;
import com.example.tienda.repository.VehiculoRepository;
import com.example.tienda.service.VehiculoService;

@Service("vehiculoServiceImpl")
public class VehiculoServiceImpl implements VehiculoService{
	public static final Log Log = LogFactory.getLog(PersonServiceImpl.class);
	
	@Autowired
	@Qualifier("VehiculoRepository")
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public List<Vehiculo> buscarVehiculoXPrecio(double precio) {
		Log.info("buscarVehiculoXPrecio"+"("+precio+");");
		List<Vehiculo> lista = new ArrayList<>(); 
		lista = (List<Vehiculo>) vehiculoRepository.buscarXPrecio(precio);
		return lista ;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Vehiculo buscarXId(int id) {
		Log.info("Vehiculo buscarXId"+"("+id+");");
		Optional vehiculo = vehiculoRepository.findById(id);
		if (vehiculo.isPresent()) {
		return (Vehiculo) vehiculo.get();
		}
		return null ;
	}	
} 

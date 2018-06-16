package com.example.tienda.service.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Tarjeta;
import com.example.tienda.repository.TarjetaRepository;
import com.example.tienda.service.TarjetaService;

@Service("tarjetaServiceImpl")
public class TarjetaServiceImpl implements TarjetaService{
	public static final Log Log = LogFactory.getLog(TarjetaService.class);
	@Autowired
	
	@Qualifier("TarjetaRepository")
	private TarjetaRepository tarjetaRepository;
	
	@Override
	public Tarjeta save(Tarjeta tarjeta) {
		Log.info("Tarjeta save()");
		return tarjetaRepository.save(tarjeta);
	}
	
}

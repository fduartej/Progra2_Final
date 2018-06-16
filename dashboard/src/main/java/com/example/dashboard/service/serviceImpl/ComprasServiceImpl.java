package com.example.dashboard.service.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dashboard.model.Compras;
import com.example.dashboard.repository.ComprasRepository;
import com.example.dashboard.service.ComprasService;

@Service("comprasServiceImpl")
public class ComprasServiceImpl implements ComprasService{

	public static final Log Log = LogFactory.getLog(ComprasServiceImpl.class);

	@Autowired
	@Qualifier("ComprasRepository")
	private ComprasRepository comprasRepository;
	
	@Override
	public Compras save(Compras compras) {
		Log.info("ComprasServiceImpl- save");
		return comprasRepository.save(compras);
	}

	@Override
	public int contar() {
		return (int) comprasRepository.count();
	}

}

package com.example.tienda.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tienda.model.Compras;
import com.example.tienda.model.Person;
import com.example.tienda.model.Tarjeta;
import com.example.tienda.model.Vehiculo;
import com.example.tienda.service.serviceImpl.ComprasServiceImpl;
import com.example.tienda.service.serviceImpl.PersonServiceImpl;
import com.example.tienda.service.serviceImpl.TarjetaServiceImpl;
import com.example.tienda.service.serviceImpl.VehiculoServiceImpl;

@Controller
public class VehiculoController {
	@Autowired
	@Qualifier("personServiceImpl")
	private PersonServiceImpl personServiceImpl;

	@Autowired
	@Qualifier("vehiculoServiceImpl")
	private VehiculoServiceImpl vehiculoServiceImpl;
	
	@Autowired
	@Qualifier("comprasServiceImpl")
	private ComprasServiceImpl comprasServiceImpl;
	
	@Autowired
	@Qualifier("tarjetaServiceImpl")
	private TarjetaServiceImpl tarjetaServiceImpl; 
	
	@GetMapping("/lista/{codigo}")
	public String modelandview1(@PathVariable("codigo") int codigo, Model model) {
		Person person = personServiceImpl.buscarXId(codigo);
		model.addAttribute("person", person);
		model.addAttribute("title", "Lista de Autos");		
		return "transicion"; 
	}
	
	@PostMapping("/lista_autos")
	public String modelandview2(@ModelAttribute("person") Person person,Model model) {
		System.out.println("dd: "+person.getId());
		int codigo = person.getId();
		Person person1 = personServiceImpl.buscarXId(codigo);
		double totalneto = person1.getTotalNeto();
		List<Vehiculo> listaV = vehiculoServiceImpl.buscarVehiculoXPrecio(totalneto);
		for (Vehiculo vehiculo : listaV) {
			System.out.println(vehiculo);
		}
		model.addAttribute("person", person1);
		model.addAttribute("codigo", codigo);
		model.addAttribute("cars", listaV);
		return "lista"; 
	}
	
	@GetMapping("/comprar/{carID}/{personID}")
	public String modelandview3(
			@PathVariable("carID") int carid,
	        @PathVariable("personID") int personid,
	        Model model) {
		System.out.println("Id vehiculo: "+carid);
		System.out.println("Id Persona: "+personid);
		Compras compras  = new Compras();
		compras.setIdperson(personid);
		compras.setIdvehiculo(carid);
		compras.setFechacompra(ahora());
		comprasServiceImpl.save(compras);
		
		Vehiculo vehiculo = vehiculoServiceImpl.buscarXId(carid);
		long preciovehiculo = vehiculo.getPrecio();
		
//		System.out.println(compras.getId());
		Tarjeta tarjeta = new Tarjeta();
		model.addAttribute("carID", carid);
		model.addAttribute("precio", preciovehiculo);
		model.addAttribute("personid", personid);
		model.addAttribute("tarjeta", tarjeta);
		return "listaTMP"; 
	}
	
	@PostMapping("/comprar2")
	public String modelandview4(@ModelAttribute("tarjeta") Tarjeta tarjeta){
//		String numero = tarjeta.getNumero();
//		int codigo = tarjeta.getCodigo();
//		String expiracion = tarjeta.getExpiracion();
//		int idperson = tarjeta.getIdperson();
		tarjetaServiceImpl.save(tarjeta);
		return "listaTMP2"; 
	}
	
	public String ahora() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}

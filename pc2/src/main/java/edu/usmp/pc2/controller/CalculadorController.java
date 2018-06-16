package edu.usmp.pc2.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import edu.usmp.pc2.model.Person;
import edu.usmp.pc2.repository.PersonRepository;
import edu.usmp.pc2.service.serviceImpl.MailServiceImpl;
import edu.usmp.pc2.service.serviceImpl.PersonServiceImpl;

@Controller
public class CalculadorController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	@Qualifier("mailServiceImpl")
	private MailServiceImpl mailServiceImpl;
	
	@Autowired
	@Qualifier("personServiceImpl")
	private PersonServiceImpl personServiceImpl;
	
	public Person calcularIngreso(Person person)
	{
		double impTotal = 0;
		double [] monto = new double[5];
		double[] impAfecto = new double[5];
		
		//double salarioAnual = 0;
		
		person.setIngresoAnual(person.getRelacionLaboral().equals("Independiente")?12.0*person.getIngresoAnual():14.0*person.getIngresoAnual());
		
		person.setTotalBruto(round(person.getIngresoAnual(),2));
		
		double sUit = person.getUit() * 7;
		
		double rentaNeta = person.getIngresoAnual() - sUit;
		
		double [] montos = {5*person.getUit(),20*person.getUit(),35*person.getUit(), 45*person.getUit()};
		
		if (rentaNeta > 0)
		{
			if(rentaNeta<= montos[0])
			{
				monto[0] = rentaNeta;
				impAfecto[0] = monto[0] * 0.08;
			}else
			{
				monto[0] = montos[0];
				impAfecto[0] = monto[0] * 0.08;
			}
			
			if(rentaNeta <= montos[1])
			{
				monto[1] = rentaNeta - monto[0];
				impAfecto[1] = monto[1] * 0.14;
			}else
			{
				monto[1] = montos[1] - monto[0];
				impAfecto[1] = monto[1] * 0.14;
			}
			
			if(rentaNeta <= montos[2])
			{
				monto[2] = rentaNeta - (monto[0]+monto[1]);
				impAfecto[2] = monto[2] * 0.17;
			}else
			{
				monto[2] = montos[2] - (monto[0]+monto[1]);
				impAfecto[2] = monto[2] * 0.17;
			}
			
			if(rentaNeta <= montos[3])
			{
				monto[3] = rentaNeta - (monto[0]+monto[1]+monto[2]);
				impAfecto[3] = monto[3] * 0.2;
			}else
			{
				monto[3] = montos[3] - (monto[0]+monto[1]+monto[2]);
				impAfecto[3] = monto[3] * 0.2;
			}
			
			if(rentaNeta > montos[3])
			{
				monto[4] = rentaNeta - montos[3];
				impAfecto[4] = monto[4] * 0.3;
			}else
			{
				monto[4] = 0;
				impAfecto[4] = monto[4] * 0.3;
			}
		}
		
		impTotal = calcularImp(impAfecto);
		
		person.setTotalImpuesto(round(impTotal,2));

		
		return person;
	}
	
	public double calcularImp(double [] impuesto)
	{
		double impuestoTotal = 0;
		for(int i = 0; i < impuesto.length; i++)
		{
			impuestoTotal += impuesto[i];
		}
		return impuestoTotal;
				
	}
	
	
	private double round(double value, int floatingPoint) {

	    long factor = (long) Math.pow(10, floatingPoint);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) (tmp / factor*100)/100;
	}
	
	
	@GetMapping("/")
	private String initForm(Model model) {
		model.addAttribute(new Person());
		model.addAttribute("title","Inicio");
		return "calcForm";
	}
	
	@PostMapping("/calcular")
	private String submitForm(@Valid Person person, BindingResult bindingResult) {
		
		if (bindingResult.hasFieldErrors()) {
			return "calcForm";
		}
		Person persons = calcularIngreso(person);
//		mailServiceImpl.enviarCorreo(person.getCorreo());
		person.setTotalNeto(person.getTotalBruto()-person.getTotalImpuesto());
		person.setFlag_correo('0');
		personServiceImpl.addPerson(persons);
		System.out.println("Calcular - ID: "+persons.getId());
		return "redirect:/resultado/"+persons.getId()+"";
	}
	
	@GetMapping("/listarTrabajador")
	private String listado(Map<String, Object> model, Model modelo) {		
		List<Person> persons = personRepository.findAll();
		model.put("persons", persons);
		modelo.addAttribute("title","Resultados");
		return "listarTrabajador";
	}
	
	@GetMapping("/resultado/{id}")
	private String resultado(@PathVariable("id") int id,Model model) {
		System.out.println(""+id);
		Person person = personServiceImpl.buscarXId(id);
		model.addAttribute("person", person);
		model.addAttribute("title","Resultados");
		return "resultado";
	}
}

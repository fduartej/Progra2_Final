package com.example.dashboard.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dashboard.service.serviceImpl.ComprasServiceImpl;
import com.example.dashboard.service.serviceImpl.PersonServiceImpl;
import com.example.dashboard.service.serviceImpl.VehiculoServiceImpl;

@Controller
public class MainController {

	@Autowired
	@Qualifier("comprasServiceImpl")
	private ComprasServiceImpl comprasServiceImpl;
	
	@Autowired
	@Qualifier("personServiceImpl")
	private PersonServiceImpl personServiceImpl;
	
	@Autowired
	@Qualifier("vehiculoServiceImpl")
	private VehiculoServiceImpl vehiculoServiceImpl;
	
	@GetMapping("/main")
	public String main(Model model) {
//		ModelAndView mav = new ModelAndView("index");
		model.addAttribute("ncompras", comprasServiceImpl.contar());
		model.addAttribute("nperson", personServiceImpl.contar());
		model.addAttribute("nvehiculo", vehiculoServiceImpl.contar());
		model.addAttribute("fecha", ahora());
		return "index";
	}
	
	@GetMapping("/charts")
	public String charts(Model model) {
//		ModelAndView mav = new ModelAndView("charts");
		model.addAttribute("ncompras", comprasServiceImpl.contar());
		model.addAttribute("nperson", personServiceImpl.contar());
		model.addAttribute("nvehiculo", vehiculoServiceImpl.contar());
		return "charts";
	}
	
	public String ahora() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}

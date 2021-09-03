package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;


@Controller
public class IndexController {
	
	//@Autowired
	//private MiServicio servicio;
	
	//@Autowired
	//private MiServicio servicio =new MiServicio();
	
	//@Qualifier("miServicioPrincipal")		
	
	@Autowired
	private IServicio servicio;
	
	/*
		public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}
	*/
	
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}
/*
	@Autowired
	public void setServicio(MiServicio servicio) {
		this.servicio = servicio;
	}
	
	
	*/

}

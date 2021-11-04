package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Portada {
	@GetMapping("")
	public String portada() {
		return "index";
	}
	
	@GetMapping("/que")
	public String queHacemos() {
		return "que";
	}
	
	@GetMapping("/contacto")
	public String datosContacto() {
		return "contacto";
	}
	
	// ejemplo mandar datos entre controlador y vista
	@GetMapping("/saludo")
	public String saludoPersona(Model model) {
		String atributo = "Hola pepe";
		model.addAttribute("nombre", atributo);
		return "saludo";
	}
}

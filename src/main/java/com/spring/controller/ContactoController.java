package com.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.models.Contacto;

@Controller
@RequestMapping("/contactoAgenda")
public class ContactoController {
	public ArrayList<Contacto> lista = new ArrayList<Contacto>();
	
	// ejemplo pasar datos en array y objeto
	@GetMapping("")
	public String verDatos(Model model) {
		this.lista.addAll(listaContactos());
		model.addAttribute("lista", this.lista);
		return "verDatos";
	}
	
	// obtener parametros de una peticion
	@GetMapping("altaContacto")
	public String alta(@RequestParam String nombre,@RequestParam String apellido, @RequestParam String telefono, Model model) {
		Contacto nuevo = new Contacto(nombre, apellido, telefono);
		this.lista.add(nuevo);
		model.addAttribute("lista", this.lista);
		return "verDatos";
	}
	
	// mostrar una pagina con un formulario
	@GetMapping("nuevo")
	public String nuevo() {
		return "contactoNuevo";
	}
	
	private ArrayList<Contacto> listaContactos(){
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		Contacto nuevo = new Contacto("Miguel", "Perez", "6666666");
		lista.add(nuevo);
		nuevo = new Contacto("Paco", "Porras", "6666666");
		lista.add(nuevo);	
		nuevo = new Contacto("Sergiöh", "Chiquis", "6666666");
		lista.add(nuevo);	
		nuevo = new Contacto("Macasarg", "CAPITAN", "6666666");
		lista.add(nuevo);	
		nuevo = new Contacto("Jose", "PRESI", "6666666");
		lista.add(nuevo);	
		nuevo = new Contacto("Paco", "Porras", "6666666");
		lista.add(nuevo);	
		nuevo = new Contacto("Paco", "Porras", "6666666");
		lista.add(nuevo);	
		return lista;
	}
}

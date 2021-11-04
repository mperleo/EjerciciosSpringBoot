package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.models.Usuario;

@Controller
@RequestMapping("/sesion")
public class Login {
	// obtener parametros de una peticion GET
	@GetMapping("/validar")
	public String validar(@RequestParam String nombre,@RequestParam String pass, Model model ) {
		if(nombre.equals("admin") && pass.equals("1234")) {
			model.addAttribute("nombre", nombre);
			model.addAttribute("mensaje", "ha iniciado sesion correctamente");
			return "saludo";
		}
		else {
			model.addAttribute("mensaje", "Datos erroneos");
			return "login";
		}	
	}
	
	// obtener parametros de una peticion pero indicando como parte de la direccion
	@GetMapping("/validar/{n}/{c}")
	public String validar2(@PathVariable("n") String nombre,@PathVariable("c") String pass, Model model ) {
		if(nombre.equals("admin") && pass.equals("1234")) {
			model.addAttribute("nombre", nombre);
			model.addAttribute("mensaje", "ha iniciado sesion correctamente");
			return "saludo";
		}
		else {
			model.addAttribute("mensaje", "Datos erroneos");
			return "login";
		}	
	}
	
	// formulario normal con get
	@GetMapping("/formNormal")
	public String formulario() {

		return "login";
	}	
	
	@GetMapping("")
	public String formulario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);
		return "loginObjeto";
	}
	
	// obtener parametros como un modelo en un formulario POST
	@PostMapping("/validar")
	public String validarObjeto(@ModelAttribute Usuario usuario,  Model model) {
		if(usuario.getNombre().equals("admin") && usuario.getPass().equals("1234")) {
			model.addAttribute("nombre", usuario.getNombre());
			model.addAttribute("mensaje", "ha iniciado sesion correctamente usando un objeto");
			return "saludo";
		}
		else {
			model.addAttribute("mensaje", "Datos erroneos");
			return "loginObjeto";
		}	
	}
}

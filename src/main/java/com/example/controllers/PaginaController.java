package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modelo.Personas;

@Controller
/*  @RequestMapping("/raiz")*/
public class PaginaController {

	@GetMapping("/index")
	public String index() {
		
		
		
		return "index";
	}
	
	@GetMapping("/cadena")
	public String  param( @RequestParam (value="texto", required = false, defaultValue = " no envio nada ")  String  cadena, Model modelo) {
		modelo.addAttribute("valor", "el texto enviado es: "+ " " +   cadena );
		
		return  "param/ver";
		
	}
	
	@GetMapping("/listadoPersona")
	public  String  listados(Model modelo) {
		
		List<Personas> lista=  Arrays.asList (new Personas(1, "Juan", "juan@correo.com"),
																		new Personas(2,"Pedro", "pedro@correo.com"),
																		new Personas(3,"Tommy", "Tommy@correo.com")		);
		modelo.addAttribute("listadoPerso", lista);
		return "listado";
		
	}
	
	@GetMapping("/persona")
		
	public String personita( Personas p/*Integer id ,String nombre,String correo*/, Model m)  {
		/*System.out.println(id);
	    System.out.println(nombre);
		System.out.println(correo);
		m.addAttribute("ide", id)	;
		m.addAttribute("nombre", nombre)	;
	    m.addAttribute("correo", correo);*/
		m.addAttribute("algo", p);
		
		return "persona";
	}
	
}

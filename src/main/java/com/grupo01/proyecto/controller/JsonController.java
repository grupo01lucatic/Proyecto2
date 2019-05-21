package com.grupo01.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.model.Provincia;
import com.grupo01.proyecto.services.PersonaServicesImplr;

/**
 * Clase encargada de los servicios REST
 * 
 * @author Santiago Villar
 * @date 21.05.2019
 */
@RestController
@RequestMapping("/rest")
public class JsonController {

	@Autowired
	PersonaServicesImplr servicios;
	
	
	/**
	 * Servicio REST para listar contactos
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return Listado de contactos
	 */
	@GetMapping("/listadocontactos")
	public List<Persona> read() {
		return servicios.findAll();
	}
	
	/**
	 * Servicio Rest para editar contactos
	 * @author Jara Dominguez
	 * @date 21.05.2019
	 * @param id
	 */
	@GetMapping(path = { "/editarContacto{id}" })
	public Persona findOne(@PathVariable("id") int id) {
		return servicios.findOne(id);
	}

	@PutMapping(path = { "/editarContacto{id}" })
	public void update(@PathVariable("id") int id, @RequestBody Persona persona) {
		persona.setIdpersona(id);
		servicios.edit(persona);
	}
	
}

package com.grupo01.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.proyecto.model.Persona;
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
	 * Servicio REST para eliminar un contacto
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return void
	 */
	@DeleteMapping("/eliminarcontacto{id}")
	public void delete(@PathVariable int id) {
		servicios.delete(id);
	}
	
	/**
	 * Servicio REST para detalle de un contacto
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return Persona
	 */
	@GetMapping("/detallecontacto{id}")
	public Persona detallarContacto(@PathVariable int id) {
		return servicios.findOne(id);
	}
	
}

package com.grupo01.proyecto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.model.Provincia;
import com.grupo01.proyecto.services.PersonaServicesImplr;
import com.grupo01.proyecto.services.ProvinciaServiceImpl;

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
	@Autowired
	ProvinciaServiceImpl serviciosProvincia;

	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

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
	 * 
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

	/**
	 * Servicio REST para añadir provincia
	 * 
	 * @author Sagui Shahnavaz
	 * @date 21.05.2019
	 * @return void
	 */

	@PostMapping(path = { "/provincias" })
	public void anadir(@RequestBody Provincia provincia) {
		serviciosProvincia.save(provincia);
	}

	/**
	 * Servicio REST para modificiar provincia
	 * 
	 * @author Sagui Shahnavaz
	 * @date 21.05.2019
	 * @return void
	 */

	@GetMapping(path = { "/editarProvincia{id}" })
	public Provincia anadir(@PathVariable("id") int id) {
		return serviciosProvincia.findOne(id);
	}

	@PutMapping(path = { "/provincias/{id}" })
	public void update(@PathVariable("id") int id, @RequestBody Provincia provincia) {
		provincia.setIdprovincia(id);
		serviciosProvincia.save(provincia);
	}

	/**
	 * Servicio REST para listar las provincias
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return List<Provincia>
	 */
	@GetMapping("/listarprovincias")
	public List<Provincia> listarProvincias() {
		return serviciosProvincia.findAll();
	}

	/**
	 * Servicio REST para eliminar provincias
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return List<Provincia>
	 */
	@DeleteMapping("/eliminarprovincia{id}")
	public void eliminarProvincias(@PathVariable int id) {
		serviciosProvincia.delete(id);
	}

	/**
	 * Servicio REST para crear contacto
	 * @date 22.05.2019
	 * @autor Jara Dominguez
	 * @param persona
	 */
	@PutMapping(path = { "/crearcontacto" })
	public void anadirContacto(@RequestBody Persona persona) {
		servicios.save(persona);
	}

  /**
	 * Servicio REST para buscar contactos
	 * 
	 * @author Santiago Villar
	 * @date 21.05.2019
	 * @return List<Persona>
	 */
	@GetMapping("/BuscarContactos{contacto}")
	public List<Persona> listarContacto(@PathVariable String contacto) {
		List<Persona> personas;

		if (contacto.trim().length() > 0) {
			personas = (List<Persona>) servicios.findByNameOrPhone(contacto);
			logger.info("Se ha encontrado el contacto");
			return personas;
		} else {
			personas = servicios.findAll();
			logger.info("No se han encontrado los contactos");
			return personas;
		}
	}

}

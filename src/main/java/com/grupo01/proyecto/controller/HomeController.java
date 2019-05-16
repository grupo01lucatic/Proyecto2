package com.grupo01.proyecto.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.services.IPersonaService;
import com.grupo01.proyecto.services.PersonaServiceImpl;

/**
 * Clase HomeController. Esta clase es la controladora de la vista. 14/05/2019
 * 
 * @version 1.0
 * @author grupo01
 *
 */
@Controller
public class HomeController {
	private IPersonaService personaservice;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * @return Devuelve la pagina principal.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		logger.info("-- iniciada pagina de bienvenida");
		return "createuser";
	}

	/**
	 * 1 * Descripcion: controller 2 * Fecha: 16.05.2019 3 * @version 1.0 4
	 * * @author Grupo01 5 * @return Devuelve a la pagina crear usuario nuevo
	 */

	@RequestMapping(value = "/iracreateuser", method = RequestMethod.GET)
	public String createuser() {
		logger.info("-- iniciada pagina de contacto nuevo");
		return "redirect:/createuser";
	}

	/**
	 * 1 * Descripcion: controller 2 * Fecha: 16.05.2019 3 * @version 1.0 4
	 * * @author Grupo01 5 * @return Devuelve a la pagina listado de contactos
	 */
	@RequestMapping(value = "/iraListarContacto", method = RequestMethod.GET)
	public String ListarContactos() {
		logger.info("-- iniciada pagina de listado de contacto");
		return "redirect:/ListarContactos";
	}

	/**
	 * @author Ivan Carpio Fecha: 14.05.2019 GET Recibe un objeto de tipo Persona y
	 *         lo añade al Map del modelo Persona
	 * @version 1.0
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Persona cliente = new Persona();
		model.put("persona", cliente);
		return "create";
	}

	/**
	 * @author Ivan Carpio Fecha: 14.05.2019 Inserta un contacto nuevo a la base de
	 *         datos cuando pulsas el boton Crear de la vista createuser.Si hay
	 *         algun error retorna al formulario y si todo es correcto redirige a la
	 *         raiz.
	 * @version 1.0
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	// @Valid, BindingResult necesarios para validar los campos
	public String guardar(@Valid Persona cliente, BindingResult result, Model model, SessionStatus status) {
		personaservice.save(cliente);
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/Detalle/{id}") // En la vista tiene que que llevar
	public String Detalle(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Persona persona = null;

		if (id > 0) {
			persona = personaservice.findOne(id);
		} else {
			return "redirect:/Index";
		}
		model.put("persona", persona);
		model.put("titulo", "Detalle");
		return "DetallePersona";
	}

	/**
	 * @author Jara Dominguez Fecha: 16.05.2019 Llama a un metodo en servicios que
	 *         tiene una lista de contacto y muestra la lista en el html
	 *         ListarContactos
	 * @version 1.0
	 */
	@GetMapping("/ListarContactos")
	public String listarContacto(Model model) {
		model.addAttribute("personas", personaservice.findAll());
		logger.info("Se han mostrado los contactos");
		return "ListarContactos";
	}
}

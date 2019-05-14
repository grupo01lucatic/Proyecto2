package com.grupo01.proyecto.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.services.IPersonaService;

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
		return "index";
	}

	/**@author Ivan Carpio
	 * Fecha: 14.05.2019
	 * GET Recibe un objeto de tipo Persona y lo añade al Map del modelo Persona 
	 * @version 1.0*/
	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Persona persona = new Persona();
		model.put("persona", persona);
		logger.info("Se ha creado un nuevo contacto");
		return "createuser";
	}

	/**@author Ivan Carpio
	 * Fecha: 14.05.2019
	 * Inserta un contacto nuevo a la base de datos cuando pulsas el boton Crear de la vista createuser.Si hay
	 * algun error retorna al formulario y si todo es correcto redirige a la raiz.
	 * @version 1.0
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	// @Valid, BindingResult necesarios para validar los campos
	public String guardar(@Valid Persona persona, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			logger.info("No se ha añadido ningun registro, porque hay errores");
			return "createuser";
		}
		personaservice.save(persona);
		status.setComplete();
		logger.info("Se ha añadido el registro correctamente");
		return "redirect:/";
	}
}

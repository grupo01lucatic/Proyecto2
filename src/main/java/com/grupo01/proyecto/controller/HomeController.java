package com.grupo01.proyecto.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "createuser";
	}

	/**@author Ivan Carpio
	 * Fecha: 14.05.2019
	 * GET Recibe un objeto de tipo Persona y lo añade al Map del modelo Persona 
	 * @version 1.0*/
	@RequestMapping(value="/createuser")
	public String crear(Map<String, Object> model) {
		Persona cliente = new Persona();
		model.put("persona", cliente);
		return "create";
	}

	/**@author Ivan Carpio
	 * Fecha: 14.05.2019
	 * Inserta un contacto nuevo a la base de datos cuando pulsas el boton Crear de la vista createuser.Si hay
	 * algun error retorna al formulario y si todo es correcto redirige a la raiz.
	 * @version 1.0
	 */
	@RequestMapping(value="/createuser", method=RequestMethod.POST)
	//@Valid, BindingResult necesarios para validar los campos
	public String guardar(@Valid Persona cliente, BindingResult result, Model model, SessionStatus status) {
	personaservice.save(cliente);
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/Detalle/{id}")  // En la vista tiene que que llevar 
	public String Detalle(@PathVariable(value="id") Long id, Map<String,Object> model) {
		Persona persona = null;
	
		if(id>0) {
			persona = personaservice.findOne(id);
		}else {
			return "redirect:/Index";
		}
		model.put("persona", persona);
		model.put("titulo", "Detalle");
		return "DetallePersona";
	}

}

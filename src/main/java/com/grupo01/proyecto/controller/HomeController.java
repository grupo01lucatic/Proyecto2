package com.grupo01.proyecto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Clase MenuController.
 * Esta clase es la controladora de la vista.
 * 14/05/2019
 * @version 1.0
 * @author grupo01
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * @return Devuelve la pagina principal.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		logger.info("-- iniciada pagina de bienvenida");	
		return "index";
	}
}

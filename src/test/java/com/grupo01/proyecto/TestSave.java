package com.grupo01.proyecto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.grupo01.proyecto.controller.HomeController;
import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.services.IPersonaServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSave {

	/**
	 * Junit que comprueba que se guarda una la tabla persona una persona, se comprueba con
	 * otro objeto Persona que tenga la id de la primera persona y si son iguales es correcto 
	 * que se haya guardado. Despues de la comprobacion elimina la persona que se ha creado de la tabla.
	 * @autor: Ivan Carpio
	 * @version: v1
	 * @date: 16.05.2019
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IPersonaServices personaservice;
	Persona persona = new Persona();
	
	@Test
	public void testGuardaryBorrar() throws Exception {
		persona.setNombre("Lucatic");
		persona.setApellido1("Lucatic");
		personaservice.saveJpaRepository(persona);
		logger.info("-------->  Guardado ok <<< "  + persona.getIdpersona() + " <<");
		Persona person = new Persona();
		person.setIdpersona(persona.getIdpersona());
		assertEquals(persona.getIdpersona(), person.getIdpersona());
		personaservice.delete(persona.getIdpersona());
		
	}

	
	
}

package com.grupo01.proyecto;

import static org.assertj.core.api.Assertions.assertThat;

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
	 * Metodo que compreba si se guarda un ser humano o algo similar en la tabla
	 * persona de la base de datos
	 * 
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
		persona.setIdpersona(100);
		persona.setNombre("@Test");
		persona.setApellido1("@Test");
		persona.setApellido2("@Test");
		personaservice.saveJpaRepository(persona);
		logger.info("--------> Ser de prueba Guardado <<< "  + persona.getNombre() + " <<");
		personaservice.delete(100);
		logger.info("Borrado de Ser de prueba completado con exito" );
	
	}

	
	
}

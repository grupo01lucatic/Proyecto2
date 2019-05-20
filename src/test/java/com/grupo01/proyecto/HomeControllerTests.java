package com.grupo01.proyecto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grupo01.proyecto.controller.HomeController;

/**
 * Clase HomeControllerTest. Esta clase es la que se encarga de realizar las
 * pruebas unitarias al HomeController. 14/05/2019
 * 
 * @version 1.0
 * @author Santiago Villar
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTests {

	/**
	 * Instancia del HomeController.
	 */
	@Autowired
	HomeController controller;

	/**
	 * Esta prueba unitaria comprueba si el metodo para cargar la pagina principal
	 * devuelve la pagina.
	 */
	@Test
	public void testIndex() {
		assertEquals("index", controller.index());
	}
}

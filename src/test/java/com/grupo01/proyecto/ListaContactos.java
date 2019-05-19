package com.grupo01.proyecto;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grupo01.proyecto.services.PersonaServicesImplr;

/**
 * Clase ListaExiste. Esta clase es la que se encarga de realizar las pruebas
 * unitarias para saber que existen contactos creados. 16/05/2019
 * 
 * @version 1.0
 * @author grupo01
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListaContactos {

	@Autowired
	private PersonaServicesImplr listaContactos;

	/**
	 * @autor: Jara Dominguez
	 * @Date: 16/05/2019
	 * @throws Exception Este metodo falla si la listaContactos esta vacia. En caso
	 *                   contrario, funciona bien.
	 */
	@Test
	public void contextLoads() throws Exception {
		assertFalse(((listaContactos.findAll()).equals(null)));
	}
}

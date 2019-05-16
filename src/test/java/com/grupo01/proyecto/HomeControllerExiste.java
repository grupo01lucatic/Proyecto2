package com.grupo01.proyecto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grupo01.proyecto.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerExiste {
	
	/**
	 * Esta prueba comprueba que el controlador existe
	 * @autor: Jara Dominguez
	 * @version: v1
	 * @date: 16.05.2019
	 */
	
	@Autowired
	private HomeController controller;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}
}

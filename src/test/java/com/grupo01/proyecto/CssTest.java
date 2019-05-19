package com.grupo01.proyecto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 1 * Nombre: EstilosCss 2 * Descripcion: Este metodo fallaria si no existiera
 * la hoja de estilos. 3 * Fecha: 16.05.2019 4 * @version 1.0 5 * @author Sagui
 * Shahnavaz- Grupo01 6 * @throws Exception
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CssTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void CssFile() throws Exception {

		this.mockMvc.perform(get("../static/stilos.css")).andDo(print()).andExpect(status().isOk());

	}

}

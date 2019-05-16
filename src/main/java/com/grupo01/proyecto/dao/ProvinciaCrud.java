package com.grupo01.proyecto.dao;

import org.springframework.data.repository.CrudRepository;

import com.grupo01.proyecto.model.Provincia;

/**
 * Clase ProvinciaCrud. Esta clase implementa la clase CrudRepository que se
 * encarga del CRUD. 16/05/2019
 * 
 * @version 1.0
 * @author grupo01
 *
 */

public interface ProvinciaCrud extends CrudRepository<Provincia, Long> {

}

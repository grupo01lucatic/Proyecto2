package com.grupo01.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.grupo01.proyecto.model.Persona;

/**
 * Clase ContactoCrud. Esta clase implementa la clase CrudRepository que se
 * encarga del CRUD. 14/05/2019
 * 
 * @version 1.0
 * @author grupo01
 *
 */
public interface ContactoCrud extends JpaRepository<Persona, Integer> {

}

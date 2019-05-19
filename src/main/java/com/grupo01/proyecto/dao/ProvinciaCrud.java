package com.grupo01.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.model.Provincia;

/**
 * Clase ProvinciaCrud. Esta clase implementa la clase JpaRepository que se
 * encarga del CRUD. 16/05/2019
 * 
 * @version 1.0
 * @author Santiago Villar
 *
 */
@Transactional
@Repository
public interface ProvinciaCrud extends JpaRepository<Provincia, Integer> {

}

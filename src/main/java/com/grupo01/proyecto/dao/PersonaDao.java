package com.grupo01.proyecto.dao;


import org.springframework.data.repository.CrudRepository;

import com.grupo01.proyecto.model.Persona;


public interface PersonaDao extends CrudRepository<Persona, Integer>{

}

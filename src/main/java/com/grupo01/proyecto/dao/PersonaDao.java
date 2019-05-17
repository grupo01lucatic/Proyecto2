package com.grupo01.proyecto.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.model.Persona;

@Transactional  
@Repository  
public interface PersonaDao extends JpaRepository<Persona, Integer>{

}

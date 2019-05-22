package com.grupo01.proyecto.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.grupo01.proyecto.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
	@Query("SELECT DISTINCT new com.grupo01.proyecto.model.Persona(p.idpersona, p.nombre, p.apellido1, p.apellido2) FROM Persona p INNER JOIN Telefono t ON t.persona=p.id WHERE (p.nombre LIKE %:query% OR p.apellido1 LIKE %:query% OR p.apellido2 LIKE %:query% OR t.telefono LIKE %:query%)")
	public Iterable<Persona> findByNameOrPhone(@Param("query") String query);
}

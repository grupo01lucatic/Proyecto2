package com.grupo01.proyecto.services;

import com.grupo01.proyecto.model.Persona;

public interface IPersonaService {
	public Iterable<Persona> findAll();

	public void save(Persona persona);

	public Persona findOne(Long id);

	public void delete(Long id);
}

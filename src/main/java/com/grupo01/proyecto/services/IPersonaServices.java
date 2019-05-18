package com.grupo01.proyecto.services;

import java.util.List;

import com.grupo01.proyecto.model.Persona;

public interface IPersonaServices {
	public List<Persona> findAll();

	public void save(Persona p);

	public Persona findOne(int id);

	public void delete(int id);

	void saveJpaRepository(Persona persona);
}

package com.grupo01.proyecto.services;

import java.util.List;

import com.grupo01.proyecto.model.Persona;



public interface IPersonaService {
	public List<Persona> findAll();
	
	public void save(Persona persona);
	
	public Persona findOne(Long id);
	
	public void delete(Long id);
}

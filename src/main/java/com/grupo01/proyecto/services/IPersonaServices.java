package com.grupo01.proyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo01.proyecto.model.Persona;
@Service
public interface IPersonaServices {
	public List<Persona> findAll();

	public void save(Persona p);
	
	public void edit(Persona p);

	public Persona findOne(int id);

	public void delete(int id);

	void saveJpaRepository(Persona persona);

	public Iterable<Persona> findByNameOrPhone(String search);
	
	
	//public List<Persona> findPersonaByProvincia(String search);
}

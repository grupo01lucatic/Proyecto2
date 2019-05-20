package com.grupo01.proyecto.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.grupo01.proyecto.model.Direccion;
import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.model.Telefono;


@Component
public class PersonaDaoCust {
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private TelefonoRepository telefonoRepository;
	
	@Autowired
	private DireccionRepository direccionRepository;

	public Iterable<Persona> findAll() {
		return personaRepository.findAll();
	}

	public boolean create(Persona persona) {		
		Persona personaSaved = personaRepository.save(persona);
		
		List<Telefono> telefonos = persona.getTelefonos();
		List<Direccion> direcciones = persona.getDireccions();
		
		for(int i = 0; i < telefonos.size(); i++) {
			Telefono telefono = telefonos.get(i);
			telefono.setPersona(personaSaved);
			telefonoRepository.save(telefono);
		}
		
		for(int j = 0; j < direcciones.size(); j++) {
			Direccion direccion = direcciones.get(j);
			direccion.setPersona(personaSaved);
			direccionRepository.save(direccion);
		}
		
		if (persona.isValid()) {
			return true;
		} else {
			return false;
		}
	}

	public Optional<Persona> findById(Integer id) {
		return personaRepository.findById(id);
	}

	public boolean editar(Persona persona) {		
		if (persona.isValid() && personaRepository.existsById(persona.getIdpersona())) {			
			List<Telefono> telefonos = persona.getTelefonos();
			List<Direccion> direcciones = persona.getDireccions();
			
			for(int i = 0; i < telefonos.size(); i++) {
				Telefono telefono = telefonos.get(i);
				telefono.setPersona(persona);
				telefonoRepository.save(telefono);
			}
			
			for(int j = 0; j < direcciones.size(); j++) {
				Direccion direccion = direcciones.get(j);
				direccion.setPersona(persona);
				direccionRepository.save(direccion);
			}
			
			personaRepository.save(persona);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteById(int id) {
		try {
			personaRepository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	
}
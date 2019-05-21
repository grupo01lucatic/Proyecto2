package com.grupo01.proyecto.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.grupo01.proyecto.model.Direccion;
import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.model.Telefono;

/**
 * @author admin
 *
 */
@Component
public class PersonaDaoCust {
	@Autowired
	private PersonaDao personaRepository;

	@Autowired
	private TelefonoRepository telefonoRepository;

	@Autowired
	private DireccionRepository direccionRepository;

	/**
	 * @return
	 */
	public Iterable<Persona> findAll() {
		return personaRepository.findAll();
	}

	/**
	 * Metodo de JpaRepository Persona, Telefono, Direccion que añade un nuevo
	 * contacto a la tabla persona y las tablas asociadas a la id de esta persona.
	 * 
	 * @param persona
	 * @return
	 */
	public boolean create(Persona persona) {
		Persona personaSaved = personaRepository.save(persona);

		List<Telefono> telefonos = persona.getTelefonos();
		List<Direccion> direcciones = persona.getDireccions();

		for (int i = 0; i < telefonos.size(); i++) {
			Telefono telefono = telefonos.get(i);
			telefono.setPersona(personaSaved);
			telefonoRepository.save(telefono);
		}

		for (int j = 0; j < direcciones.size(); j++) {
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

	/**
	 * Metodo de JpaReposturory que busca la id de una persona y devuelve todos sus
	 * campos
	 * 
	 * @param id
	 * @return Optional
	 */
	public Optional<Persona> findById(Integer id) {
		return personaRepository.findById(id);
	}

	/**
	 * Metodo de JpaRepository Persona, Telefono, Direccion que busca la id de un
	 * contacto y devuelve todos sus campos
	 * 
	 * @param persona
	 * @return
	 */
	public boolean editar(Persona persona) {
		if (persona.isValid() && personaRepository.existsById(persona.getIdpersona())) {
			List<Telefono> telefonos = persona.getTelefonos();
			List<Direccion> direcciones = persona.getDireccions();

			for (int i = 0; i < telefonos.size(); i++) {
				Telefono telefono = telefonos.get(i);
				telefono.setPersona(persona);
				telefonoRepository.save(telefono);
			}

			for (int j = 0; j < direcciones.size(); j++) {
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

	/**
	 * Metodo de JpaRepository Persona, Telefono, Direccion que busca la id de un
	 * contacto y elimina todos los campos relacionados con esa id.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id) {
		try {
			Persona persona = personaRepository.findById(id).orElse(null);
			for (int i = 0; i < persona.getDireccions().size(); i++) {
				direccionRepository.deleteById(persona.getDireccions().get(i).getIddireccion());
			}
			for (int i = 0; i < persona.getTelefonos().size(); i++) {
				telefonoRepository.deleteById(persona.getTelefonos().get(i).getIdtelefono());
			}
			personaRepository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

}
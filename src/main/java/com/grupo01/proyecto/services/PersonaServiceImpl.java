package com.grupo01.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.dao.ContactoCrud;


public class PersonaServiceImpl implements IPersonaService{
	@Autowired
	private ContactoCrud contactocrud;
	
	@Override
	public List<Persona> findAll() {	
		return null;
	}
	
	/**Metodo que recibe un objeto tipo Persona y lo guarda en la base de datos a traves de l implimentacion
	 * del metodo save de CrudRepository */
	@Override
	@Transactional
	public void save(Persona persona) {
		contactocrud.save(persona);		
	}

	@Override
	public Persona findOne(Long id) {
		
		return null;
	}

	@Override
	public void delete(Long id) {
	
		
	}

}

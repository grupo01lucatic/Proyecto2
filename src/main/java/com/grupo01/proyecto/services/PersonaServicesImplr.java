package com.grupo01.proyecto.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.dao.PersonaDao;
import com.grupo01.proyecto.model.Persona;



@Service
public class PersonaServicesImplr implements IPersonaServices {
	

	@Autowired	
	private PersonaDao clienteDao;
	
	@Override
	@Transactional(readOnly=true) // Solo Consultas
	public List<Persona> findAll() {
		return (List<Persona>) clienteDao.findAll();
	}

	@Override
	@Transactional //Actualiza la tabla
	public void save(Persona cliente) {
		clienteDao.save(cliente);		
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findOne(int id) {		
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int  id) {
		clienteDao.deleteById(id);
	}
}

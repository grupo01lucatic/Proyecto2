package com.grupo01.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.dao.PersonaDao;
import com.grupo01.proyecto.dao.PersonaDaoCust;
import com.grupo01.proyecto.model.Persona;

@Service
public class PersonaServicesImplr implements IPersonaServices {

	@Autowired
	private PersonaDao clienteDao;

	@Autowired
	private PersonaDaoCust personaDaoCust;

	@Override
	@Transactional(readOnly = true) // Solo Consultas
	public List<Persona> findAll() {
		return (List<Persona>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		personaDaoCust.create(persona);
	}
	
	@Override
	@Transactional
	public void edit(Persona persona) {
		personaDaoCust.editar(persona);
	}
	
	@Override
	@Transactional // Llamada del metodo save() de JpaRepository
	public void saveJpaRepository(Persona persona) {
		// clienteDao.save(cliente);
		clienteDao.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findOne(int id) {
		return personaDaoCust.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		clienteDao.deleteById(id);
	}
}

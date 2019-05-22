package com.grupo01.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo01.proyecto.dao.PersonaDao;
import com.grupo01.proyecto.dao.PersonaDaoCust;
import com.grupo01.proyecto.dao.PersonaRepository;
import com.grupo01.proyecto.model.Persona;

@Service
@Transactional
public class PersonaServicesImplr implements IPersonaServices {

	@Autowired
	private PersonaDao clienteDao;

	@Autowired
	private PersonaDaoCust personaDaoCust;

	@Autowired
	private PersonaRepository personaRepository;

	/** Metodo de JpaRepository que devuelve una lista con todos los contactos */
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return clienteDao.findAll();
	}

	/**
	 * Metodo save de PersonaDaoCustom que añade un objeto tipo persona con sus
	 * asociaciones a las de mas tablas
	 */
	@Override
	@Transactional
	public void save(Persona persona) {
		personaDaoCust.create(persona);
	}

	/** Llamada del metodo save de PersonaDaoCustom */
	@Override
	@Transactional
	public void edit(Persona persona) {
		personaDaoCust.editar(persona);
	}

	/** Llamada del metodo save de JpaRepository */
	@Override
	@Transactional
	public void saveJpaRepository(Persona persona) {
		// clienteDao.save(cliente);
		clienteDao.save(persona);
	}

	/**
	 * Metodo de PersonaDaoCustom que busca la id introducida para poder editarlos y
	 * mostrar sus detalles
	 */
	@Override
	@Transactional(readOnly = true)
	public Persona findOne(int id) {
		return personaDaoCust.findById(id).orElse(null);
	}

	/**
	 * Metodo de JpaRepository que busca la id introducida y elimina todos los
	 * campos asociados a esa id
	 */
	@Override
	@Transactional
	public void delete(int id) {
		personaDaoCust.deleteById(id);
	}

	@Override
	public Iterable<Persona> findByNameOrPhone(String search) {
		return personaRepository.findByNameOrPhone(search);
	}

	/*
	 * public List<Persona> findPersonaByProvincia(String search){ List<Direccion>
	 * direcciones = new ArrayList<Direccion>();
	 * 
	 * int idPr = provinciaService.getIdProvincia(search);
	 * 
	 * for (Direccion direccion : direccionRepo.findAll()) {
	 * if(direccion.getProvincia().getIdprovincia() == idPr) {
	 * direcciones.add(direccion); } }
	 * 
	 * List<Persona> personasConIdProvincia = new ArrayList<Persona>();
	 * 
	 * for (Direccion direccion : direcciones) {
	 * personasConIdProvincia.add(direccion.getPersona()); }
	 * 
	 * return personasConIdProvincia; }
	 */

}

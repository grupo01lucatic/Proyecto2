package com.grupo01.proyecto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo01.proyecto.model.Persona;

@Repository
public class PersonaDaoCust implements IPersonaDaoCust {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void darDeAltaContacto(Persona persona) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("INSERT INTO " + "persona"
				+ " (persona.nombre, persona.apellido1, persona.apellido2, persona.dni, persona.fechanacimiento) "
				+ "VALUES " + "(?, ?, ?, ?, ?)").setParameter(1, persona.getNombre())
				.setParameter(2, persona.getApellido1()).setParameter(3, persona.getApellido2())
				.setParameter(4, persona.getDni()).setParameter(5, persona.getFechanacimiento());
		query.executeUpdate();
		Query query2 = entityManager.createNativeQuery("INSERT INTO " + "telefono "
				+ "(telefono.telefono, telefono.idpersona) " + "VALUES " + "(?, LAST_INSERT_ID())")
				.setParameter(1, persona.getTelefonos().get(0).getTelefono());
		query2.executeUpdate();
	}

}

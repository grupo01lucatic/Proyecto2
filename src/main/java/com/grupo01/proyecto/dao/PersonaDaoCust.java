package com.grupo01.proyecto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grupo01.proyecto.model.Persona;

/**
 * @author Santiago Villar
 * @date 16.05.2019
 * @param Provincia
 * @return void Clase con querys personalizadas para la gestion de los
 *         contactos.
 */
@Repository
public class PersonaDaoCust implements IPersonaDaoCust {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @author Santiago Villar
	 * @date 16.05.2019
	 * @param Persona
	 * @return void Metodo que recibe un objeto tipo Persona y lo guarda en la base
	 *         de datos.
	 */
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

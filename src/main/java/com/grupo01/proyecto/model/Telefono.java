package com.grupo01.proyecto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the telefono database table.
 * 
 */
@Entity
@NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtelefono;

	private String telefono;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "idpersona")
	private Persona persona;

	public Telefono() {
	}

	public int getIdtelefono() {
		return this.idtelefono;
	}

	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
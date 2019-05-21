package com.grupo01.proyecto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
//@JsonIgnoreType
public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtelefono;

	private String telefono;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "idpersona")
	// @JsonIgnore
	private Persona persona;

	public Telefono() {
	}

	public Telefono(String telefono, Persona persona) {
		super();
		this.telefono = telefono;
		this.persona = persona;
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

	@Override
	public String toString() {
		return "Telefono [idtelefono=" + idtelefono + ", telefono=" + telefono + "]";
	}

}
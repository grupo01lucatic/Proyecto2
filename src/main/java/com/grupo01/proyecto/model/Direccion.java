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
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
//@JsonIgnoreType
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddireccion;

	private String codpostal;

	private String direccion;

	private String localidad;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "idpersona")
	// @JsonIgnore
	private Persona persona;

	// bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name = "idprovincia")
	// @JsonIgnore
	private Provincia provincia;

	public Direccion() {
	}

	public Direccion(String codpostal, String direccion, String localidad, Persona persona, Provincia provincia) {
		super();
		this.codpostal = codpostal;
		this.direccion = direccion;
		this.localidad = localidad;
		this.persona = persona;
		this.provincia = provincia;
	}

	public int getIddireccion() {
		return this.iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getCodpostal() {
		return this.codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [iddireccion=" + iddireccion + ", codpostal=" + codpostal + ", direccion=" + direccion
				+ ", localidad=" + localidad + "]";
	}

}
package com.grupo01.proyecto.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
1  * Nombre: Direccion
2  * Descripcion: Clase con setter/getter, constructor (default) y toString
3  * Fecha: 14.05.2019
4  * @version 1.0
5  * @author Sagui Shahnavaz
*/

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddireccion")
	private Long id;
	private String direccion;
	private String codpostal;
	private String localidad;
	private Long idprovincia;
	private Long idpersona;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idpersona", referencedColumnName = "idpersona", insertable = false, updatable = false)
	private Persona persona;
		
	public Direccion() {}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Long getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}

	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}




	@Override
	public String toString() {
		return "Direcciones [iddireccion=" + id + ", direccion=" + direccion + ", codpostal=" + codpostal
				+ ", localidad=" + localidad + ", idprovincia=" + idprovincia + ", idpersona=" + idpersona + "]";
	}

}

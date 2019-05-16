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
1  * Nombre: Telefono
2  * Descripcion: Clase con setter/getter, constructor (default) y toString
3  * Fecha: 14.05.2019
4  * @version 1.0
5  * @author Sagui Shahnavaz
*/

@Entity
@Table(name="telefonos")
public class Telefono implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idtelefono")
	private Long id;
	private String telefono;
		
	private Long idpersona;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="idpersona", referencedColumnName="idpersona", insertable=false, updatable=false)
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Telefono [idtelefono=" + id + ", telefono=" + telefono + ", idpersona=" + idpersona + "]";
	}

}

package com.grupo01.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
1  * Nombre: Provincia
2  * Descripcion: Clase con setter/getter, constructor (default) y toString
3  * Fecha: 14.05.2019
4  * @version 1.0
5  * @author Sagui Shahnavaz
*/

@Entity
@Table(name="provincias")
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idprovincia")
	private Long id;
	
	private String provincia;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Provincia [idprovincia=" + id + ", provincia=" + provincia + "]";
	}

}

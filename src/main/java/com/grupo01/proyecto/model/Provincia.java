package com.grupo01.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
1  * Nombre: Provincia
2  * Descripcion: Clase con setter/getter, constructor (default) y toString
3  * Fecha: 14.05.2019
4  * @version 1.0
5  * @author Sagui Shahnavaz
*/

@Entity
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprovincia;
	private String provincia;

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Provincia [idprovincia=" + idprovincia + ", provincia=" + provincia + "]";
	}

}

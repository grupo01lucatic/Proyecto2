package com.grupo01.proyecto.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersona;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechanacimiento;

	private String nombre;

	@OneToMany(mappedBy = "persona")
	private List<Direccion> direccions;

	@OneToMany(mappedBy = "persona")
	private List<Telefono> telefonos;

	public Persona() {
	}

	public Persona(int id, String nombre, String apellido1, String apellido2) {
		super();
		this.setIdpersona(id);
		this.setNombre(nombre);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
	}	

	public Persona(String apellido1, String apellido2, String dni, Date fechanacimiento, String nombre,
			List<Direccion> direccions, List<Telefono> telefonos) {
		super();
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.nombre = nombre;
		this.direccions = direccions;
		this.telefonos = telefonos;
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setPersona(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setPersona(null);

		return direccion;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setPersona(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setPersona(null);

		return telefono;
	}

	public boolean isValid() {
		if (nombre == null || nombre.trim().length() < 1) {
			return false;
		}

		if (apellido1 == null || apellido1.trim().length() < 1) {
			return false;
		}

		if (apellido2 == null || apellido2.trim().length() < 1) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni="
				+ dni + ", fechanacimiento=" + fechanacimiento + ", nombre=" + nombre + ", direccions=" + direccions
				+ ", telefonos=" + telefonos + "]";
	}

	

}
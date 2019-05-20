package com.grupo01.proyecto.services;

import java.util.List;

import com.grupo01.proyecto.model.Provincia;

public interface IProvinciaService {
	public List<Provincia> findAll();

	public void save(Provincia provincia);

	public Provincia findOne(int id);

	public void delete(int id);

}

package com.grupo01.proyecto.services;

import com.grupo01.proyecto.model.Provincia;

public interface IProvinciaService {
	public Iterable<Provincia> findAll();
	
	public void save(Provincia provincia);
	
	public Provincia findOne(Long id);
	
	public void delete(Long id);
	
}

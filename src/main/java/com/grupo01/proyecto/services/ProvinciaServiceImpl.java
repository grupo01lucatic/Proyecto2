package com.grupo01.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo01.proyecto.dao.ProvinciaCrud;
import com.grupo01.proyecto.model.Provincia;

/**
 * @author Grupo01
 * @date 16.05.2019
 * @version v1
 */

@Repository
public class ProvinciaServiceImpl implements IProvinciaService {
	@Autowired
	private ProvinciaCrud provinciacrud;
	
	@Override
	public Iterable<Provincia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @param Provincia
	 * @return void
	 * Metodo que recibe un objeto tipo Provincia y lo guarda en la base de datos a
	 * traves de l implimentacion del metodo save de CrudRepository
	 */
	
	@Override
	public void save(Provincia provincia) {
		provinciacrud.save(provincia);
		
	}

	@Override
	public Provincia findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}

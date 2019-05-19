package com.grupo01.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo01.proyecto.dao.ProvinciaCrud;
import com.grupo01.proyecto.model.Provincia;

/**
 * Clase de servicio que llama a los metodos de CRUD del paquete dao
 * 
 * @author Santiago Villar
 * @date 16.05.2019
 * @version v1
 */

@Repository
public class ProvinciaServiceImpl implements IProvinciaService {
	@Autowired
	private ProvinciaCrud provinciacrud;

	/**
	 * @author Santiago Villar
	 * @date 16.05.2019
	 * @param Provincia
	 * @return void Metodo que ejecuta el metodo para listar provincias de dao
	 */
	@Override
	public List<Provincia> findAll() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provinciacrud.findAll();
	}

	/**
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @param Provincia
	 * @return void Metodo que recibe un objeto tipo Provincia y lo guarda en la
	 *         base de datos a traves de l implimentacion del metodo save de
	 *         CrudRepository
	 */

	@Override
	public void save(Provincia provincia) {
		provinciacrud.saveAndFlush(provincia);

	}

	/**
	 * @author Santiago Villar
	 * @date 16.05.2019
	 * @param Provincia
	 * @return void Metodo que recibe una id y ejecuta el metodo buscar por id de
	 *         dao
	 */
	@Override
	public Provincia findOne(int id) {
		// TODO Auto-generated method stub
		return provinciacrud.findById(id).orElse(null);
	}

	/**
	 * @author Santiago Villar
	 * @date 16.05.2019
	 * @param Provincia
	 * @return void Metodo que recibe una id y ejecuta el metodo eliminar por id de
	 *         dao
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		provinciacrud.deleteById(id);
	}

}

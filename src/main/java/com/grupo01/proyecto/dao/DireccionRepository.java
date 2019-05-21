package com.grupo01.proyecto.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grupo01.proyecto.model.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer> {
}

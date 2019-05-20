package com.grupo01.proyecto.dao;

import org.springframework.data.repository.CrudRepository;

import com.grupo01.proyecto.model.Telefono;

public interface TelefonoRepository extends CrudRepository<Telefono, Integer> {
}

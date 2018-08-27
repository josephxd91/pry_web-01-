package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Validacion;

public interface IValidacionService {
	
	public List<Validacion> findAll();
	public void save(Validacion validacion);
	public Validacion findOne(Integer id);
	public Validacion findByIdrevisionValidacion(Integer id);
}

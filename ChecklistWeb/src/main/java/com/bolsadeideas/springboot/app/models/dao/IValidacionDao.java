package com.bolsadeideas.springboot.app.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Validacion;

public interface IValidacionDao extends CrudRepository<Validacion, Integer> {
	
	@Query("SELECT v "
			+ " FROM Validacion v WHERE v.idrevisionValidacion=?1")
	public Validacion  findByIdrevisionValidacion(Integer id);
	
}

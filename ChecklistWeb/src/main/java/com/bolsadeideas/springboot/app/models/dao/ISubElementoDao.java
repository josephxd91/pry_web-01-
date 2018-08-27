package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.SubElemento;

public interface ISubElementoDao extends CrudRepository<SubElemento, Integer> {

	@Query("select se from SubElemento se where se.nombre like %?1%")
	public List<SubElemento> findByNombre(String term);
}

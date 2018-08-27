package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.SubElemento;

public interface ISubElementoService {
	public List<SubElemento> findAll();
	
	public void save(SubElemento temaElemento);
	
	public SubElemento findOne(Integer id);
	
	public List<SubElemento> findByTemaElemento(String term);
	
	
	
}

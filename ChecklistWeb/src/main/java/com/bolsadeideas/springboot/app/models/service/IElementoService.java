package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Elemento;

public interface IElementoService {
	public List<Elemento> findAll();
	public void save(Elemento temaElemento);
	public Elemento findOne(Integer id);
	public List<Elemento> findByTemaHerramienta(String term);
}

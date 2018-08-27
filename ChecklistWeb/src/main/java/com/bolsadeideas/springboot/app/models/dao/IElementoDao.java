package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Elemento;

public interface IElementoDao extends CrudRepository<Elemento,Integer> {

}

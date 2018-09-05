package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Perfil;

public interface IPerfilDao extends CrudRepository<Perfil, Integer> {

}

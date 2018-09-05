package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Perfil;

public interface IPerfilService {
	public List<Perfil> findAll();
	public Perfil findOne(Integer id);
}

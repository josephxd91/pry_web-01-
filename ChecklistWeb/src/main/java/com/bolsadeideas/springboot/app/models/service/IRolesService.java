package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Roles;

public interface IRolesService {
	public List<Roles> findAll();
	public Roles findOne(Integer id);
}

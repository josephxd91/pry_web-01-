package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IPerfilDao;
import com.bolsadeideas.springboot.app.models.entity.Perfil;
import com.bolsadeideas.springboot.app.models.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {

	@Autowired
	private IPerfilDao perfilDao;

	@Override
	public List<Perfil> findAll() {
		return (List<Perfil>) perfilDao.findAll();
	}

	@Override
	public Perfil findOne(Integer id) {
		return perfilDao.findById(id).orElse(null);
	}

}

package com.bolsadeideas.springboot.app.models.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IUsuarioDao;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuariDao;

	

	@Override
	public void save(Usuario user) {
		usuariDao.save(user);
	}



	@Override
	public Page<Usuario> findAllCustom(Pageable pageable) {
		return usuariDao.findAll(pageable);
	}

}

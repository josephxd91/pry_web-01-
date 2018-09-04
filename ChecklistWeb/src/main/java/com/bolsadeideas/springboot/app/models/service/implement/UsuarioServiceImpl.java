package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IUsuarioDao;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IUsuarioService;


@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuariDao;

	@Override
	public List<Usuario> findAllCustom() {
		return usuariDao.findAllCustom();
	}
	
	
	
	


}

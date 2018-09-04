package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioService {
 	public List<Usuario> findAllCustom();
}

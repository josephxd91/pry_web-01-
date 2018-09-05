package com.bolsadeideas.springboot.app.models.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioService {
 	public Page<Usuario> findAllCustom(Pageable pageable);
 	public void save(Usuario user);
}

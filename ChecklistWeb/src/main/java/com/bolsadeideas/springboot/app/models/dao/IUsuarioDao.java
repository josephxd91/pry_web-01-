package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
	@Query("select u  from Usuario u")
	public List<Usuario> findAllCustom();
}

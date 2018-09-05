package com.bolsadeideas.springboot.app.models.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
	
	
	@Query("select u  from Usuario u")
	public Page<Usuario> findAllCustom(Pageable pageable);
	
	
	
	
	@Query("select u  from Usuario u where (u.nombres like %?1%)")
	public Page<Usuario> findAllCustom(String search,Pageable pageable);
}

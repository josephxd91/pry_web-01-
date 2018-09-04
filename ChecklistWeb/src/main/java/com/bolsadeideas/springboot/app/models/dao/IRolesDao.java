package com.bolsadeideas.springboot.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Roles;


public interface IRolesDao  extends CrudRepository<Roles,Integer> 
{

}

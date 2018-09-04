package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IRolesDao;
import com.bolsadeideas.springboot.app.models.entity.Roles;
import com.bolsadeideas.springboot.app.models.service.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService{
	@Autowired
	private IRolesDao rolesDao;
	
	@Override
	public List<Roles> findAll() {
		return (List<Roles>) rolesDao.findAll();
	}

	@Override
	public Roles findOne(Integer id) {
		return rolesDao.findById(id).orElse(null);
	}
	
	
}

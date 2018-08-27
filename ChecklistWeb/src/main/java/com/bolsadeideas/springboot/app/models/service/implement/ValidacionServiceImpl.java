package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IValidacionDao;
import com.bolsadeideas.springboot.app.models.entity.Validacion;
import com.bolsadeideas.springboot.app.models.service.IValidacionService;

@Service
public class ValidacionServiceImpl implements IValidacionService  {

	@Autowired
	private IValidacionDao validacionDao;
	
	
	@Override
	public List<Validacion> findAll() {
		return (List<Validacion>) validacionDao.findAll();
	}

	@Override
	public void save(Validacion validacion) {
		validacionDao.save(validacion);
	}

	@Override
	public Validacion findOne(Integer id) {
		return validacionDao.findById(id).orElse(null);
	}

	@Override
	public Validacion findByIdrevisionValidacion(Integer id) {
		return validacionDao.findByIdrevisionValidacion(id);
	}

}

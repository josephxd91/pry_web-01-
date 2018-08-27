package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IElementoDao;
import com.bolsadeideas.springboot.app.models.entity.Elemento;
//import com.bolsadeideas.springboot.app.models.entity.TemaHerramienta;
import com.bolsadeideas.springboot.app.models.service.IElementoService;

@Service
public class ElementoServiceImpl implements IElementoService{
	
	
	@Autowired
	private IElementoDao temaHerramientaDao;

	@Override
	public List<Elemento> findAll() {
		return (List<Elemento>) temaHerramientaDao.findAll();
	}

	@Override
	public void save(Elemento temaElemento) {
		// TODO Auto-generated method stub
		temaHerramientaDao.save(temaElemento);
	}

	@Override
	public Elemento findOne(Integer id) {
		return temaHerramientaDao.findById(id).orElse(null);
	}

	@Override
	public List<Elemento> findByTemaHerramienta(String term) {
		// TODO Auto-generated method stub
		return null;
	}

}

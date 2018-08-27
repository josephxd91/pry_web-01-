package com.bolsadeideas.springboot.app.models.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ISubElementoDao;
import com.bolsadeideas.springboot.app.models.entity.SubElemento;
import com.bolsadeideas.springboot.app.models.service.ISubElementoService;
@Service
public class SubElementoServiceImpl  implements ISubElementoService {
	
	@Autowired
	private ISubElementoDao temaElementoDao;
	

	@Override
	public List<SubElemento> findAll() {
		return (List<SubElemento>) temaElementoDao.findAll();
	}

	@Override
	@Transactional
	public void save(SubElemento temaElemento) {
		temaElementoDao.save(temaElemento);
	}

	@Override
	@Transactional(readOnly = true)
	public SubElemento findOne(Integer id) {
		return temaElementoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SubElemento> findByTemaElemento(String term) {
		return temaElementoDao.findByNombre(term);
	}

	

	
}

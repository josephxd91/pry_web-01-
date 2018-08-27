package com.bolsadeideas.springboot.app.models.service.implement;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.IValidacionDetalleDao;
import com.bolsadeideas.springboot.app.models.entity.ValidacionDetalle;
import com.bolsadeideas.springboot.app.models.service.IValidacionDetalleService;

@Service
public class ValidacionDetalleServiceImpl implements IValidacionDetalleService {

	@Autowired
	private IValidacionDetalleDao validacionDetalleDao;

	@Override
	public Page<ValidacionDetalle>  findByDetalleEstado(Boolean estado , Integer id , Pageable pageable) {
		return validacionDetalleDao.findByEstadoAndElemento(estado , id , pageable);   
	}
	
	
	@Override
	public Page<ValidacionDetalle> findByDetalleEstadoTitle(Boolean estado, Integer id, String title,
			Pageable pageable) {
		return validacionDetalleDao.findByEstadoAndElementoAndTitle(estado , id ,title, pageable);   
	}
	

}

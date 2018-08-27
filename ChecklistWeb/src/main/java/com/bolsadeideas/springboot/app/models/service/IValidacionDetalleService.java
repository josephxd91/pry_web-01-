package com.bolsadeideas.springboot.app.models.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.ValidacionDetalle;

public interface IValidacionDetalleService {
	public Page<ValidacionDetalle> findByDetalleEstado(Boolean estado, Integer id,Pageable pageable);
	
	public Page<ValidacionDetalle> findByDetalleEstadoTitle(Boolean estado, Integer id,String title,Pageable pageable);
}

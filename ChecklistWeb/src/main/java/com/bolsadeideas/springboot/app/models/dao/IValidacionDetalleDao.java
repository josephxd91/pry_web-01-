package com.bolsadeideas.springboot.app.models.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.ValidacionDetalle;


public interface IValidacionDetalleDao 
extends PagingAndSortingRepository<ValidacionDetalle, Integer> 
{
	
	@Query("SELECT vd FROM ValidacionDetalle vd WHERE  vd.ultimoCambio=?1 AND "
			+ "vd.idvalidacion.idsubelemento.idsubelemento=?2")  
	public Page<ValidacionDetalle> findByEstadoAndElemento(Boolean cambio , Integer id,Pageable pageable);  
	
	
	@Query("SELECT vd FROM ValidacionDetalle vd WHERE  vd.ultimoCambio=?1 AND "
			+ "vd.idvalidacion.idsubelemento.idsubelemento=?2 AND vd.idvalidacion.revision like %?3% ")
	public Page<ValidacionDetalle> findByEstadoAndElementoAndTitle(Boolean estado, Integer id, String title,
			Pageable pageable);
    
}
  
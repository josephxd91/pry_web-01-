package com.bolsadeideas.springboot.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.entity.Validacion;
import com.bolsadeideas.springboot.app.models.entity.ValidacionDetalle;
import com.bolsadeideas.springboot.app.models.service.IElementoService;
import com.bolsadeideas.springboot.app.models.service.IValidacionDetalleService;
import com.bolsadeideas.springboot.app.models.service.IValidacionService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({ "elementos" })
public class RevisionController {
	@Autowired
	private IElementoService elementoService;

	@Autowired
	private IValidacionDetalleService validacionDetalleService;

	@RequestMapping(value = { "/revision" })
	public String init(Model model) {
		model.addAttribute("cabecera", "Revision");
		model.addAttribute("elementos", elementoService.findAll());
		return "/revision/content_revision";
	}

	@RequestMapping(value = "/revision/info", method = RequestMethod.GET)
	public String  getViewInfo(@RequestParam(value = "id") Integer id , Model model) {
		System.out.println("==>eeeeeeeeee id " + id );
		Pageable pageRequest = PageRequest.of(0, 13);
		Page<ValidacionDetalle> validacionDetalle = validacionDetalleService.findByDetalleEstado(Boolean.TRUE,
				id, pageRequest);
		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>("",
				validacionDetalle);

		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		return "/revision/ajax/listado";
	}

}

package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.service.IElementoService;

@Controller
@SessionAttributes({"elementos"})
public class RevisionController {
	@Autowired
	private IElementoService elementoService;
	
	@RequestMapping(value = { "/revision" })
	public String init(Model model) {
		model.addAttribute("cabecera", "Revision");
		model.addAttribute("elementos", elementoService.findAll());
		return "/revision/content_revision";
	}
	
	
	
	
	
	
	
	
	
}

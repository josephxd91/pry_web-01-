package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RevisionController {
	
	@RequestMapping(value = { "/revision" })
	public String init(Model model) {
		model.addAttribute("cabecera", "Revision");
		return "/revision/content_revision";
	}
	
	
	
	
	
	
	
	
	
}

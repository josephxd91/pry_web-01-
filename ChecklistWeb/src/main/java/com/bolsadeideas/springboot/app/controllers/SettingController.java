package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({""})
public class SettingController {
	
	
	@RequestMapping(value = { "/setting" })
	public String init(Model model) {
//		model.addAttribute("cabecera", "Revision");
		return "/setting/content_setting";
	}

}

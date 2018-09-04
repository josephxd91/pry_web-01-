package com.bolsadeideas.springboot.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.entity.Validacion;
import com.bolsadeideas.springboot.app.models.service.IRolesService;
import com.bolsadeideas.springboot.app.models.service.IUsuarioService;

@Controller
@SessionAttributes({""})
public class SettingController {
	
	@Autowired
	private IRolesService rolesService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	
	
	
	
	@RequestMapping(value = { "/setting" })
	public String init(Model model) {
		model.addAttribute("cabecera", "Configuraciones");
		model.addAttribute("roles", rolesService.findAll());
		model.addAttribute("usuarios", usuarioService.findAllCustom());
		return "/setting/content_setting";
	}
	
	@RequestMapping(value = "/setting/aplicar_cambios", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> aplicarCambios(Usuario usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hola", "hola");
		
		System.out.println("==> " + usuario.toString());

		return map;
	}
	
	

}

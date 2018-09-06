package com.bolsadeideas.springboot.app.controllers;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IPerfilService;
import com.bolsadeideas.springboot.app.models.service.IUsuarioService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@SessionAttributes({ "" })
public class SettingController {

	private final Integer PAGES = 8;

	@Autowired
	private IPerfilService rolesService;

	@Autowired
	private IUsuarioService usuarioService;

	@RequestMapping(value = { "/setting" })
	public String init(Model model) {

		model.addAttribute("cabecera", "Configuraciones");
		model.addAttribute("roles", rolesService.findAll());
		listar_todos(model);

		return "/setting/content_setting";
	}

	private void listar_todos(Model model) {
		Pageable pageRequest = PageRequest.of(0, PAGES);
		Page<Usuario> usuarios = usuarioService.findAllCustom(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("", usuarios);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
	}

	@RequestMapping(value = "/setting/page_user", method = RequestMethod.POST)
	public String pageUser(Model model) {
		model.addAttribute("roles", rolesService.findAll());
		listar_todos(model);
		return "/setting/ajax/user";
	}

	@RequestMapping(value = "/setting/aplicar_cambios", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> aplicarCambios(Usuario usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hola", "hola");

		if (usuario.getIdusuario() == null || usuario.getIdusuario() == 0) {
			map.put("exito", "Informacion registrada correctamente");
			usuarioService.save(usuario);
		}

		System.out.println("==> " + usuario.toString());

		return map;
	}

	/// setting/page_local
	@RequestMapping(value = "/setting/page_local", method = RequestMethod.POST)
	public String pageLocal() {
		return "/setting/ajax/local";

	}

	@RequestMapping(value = { "/setting/listar" })
	public String listar(Model model) {
		listar_todos(model);
		return "/setting/ajax/listar_user";
	}

	/// setting/page_local
	
//	@PathVariable(value = "id") 
	@RequestMapping(value = "/setting/validateFolderShared", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> validarCarpetaCompartida(@RequestParam(value = "ip" , required =false) String ip,
			@RequestParam(value = "folder" , required =false ) String folder, @RequestParam(value = "hostname" , required =false) String hostname) {

		Map<String, Object> map = new HashMap<String, Object>();

//		File file = new File(folder);
//		System.out.println("existe => "  + file.exists());
//		for(File f : file.listFiles()) {
//			System.out.println("=> " + f.getPath());
//		}
		map.put("exito", null);
		map.put("error", null);
		
		InetAddress ipaddress;
		try {
			ipaddress = InetAddress.getByName(hostname);
			map.put("exito", "Conexion Exitosa");
			
		} catch (UnknownHostException e) {
			map.put("error", "Hay problemas en alcanzar dicho host");
		} 
		  
	  
		
		
		return map;
	}

}

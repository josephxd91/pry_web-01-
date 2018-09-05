package com.bolsadeideas.springboot.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = { "/setting/listar" })
	public String listar(Model model) {
		listar_todos(model);
		return "/setting/ajax/listar_user";
	}

}

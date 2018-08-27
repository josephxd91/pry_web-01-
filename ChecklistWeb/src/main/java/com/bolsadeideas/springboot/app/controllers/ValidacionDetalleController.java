package com.bolsadeideas.springboot.app.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.bolsadeideas.springboot.app.models.entity.SubElemento;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.entity.Validacion;
import com.bolsadeideas.springboot.app.models.entity.ValidacionDetalle;
import com.bolsadeideas.springboot.app.models.service.IElementoService;
import com.bolsadeideas.springboot.app.models.service.ISubElementoService;
import com.bolsadeideas.springboot.app.models.service.IValidacionDetalleService;
import com.bolsadeideas.springboot.app.models.service.IValidacionService;
import com.bolsadeideas.springboot.app.models.service.StorageService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes({ "page_number", "subElemento", "otherQuery", "title" })
public class ValidacionDetalleController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	private final StorageService storageService;

	@Autowired
	public ValidacionDetalleController(StorageService storageService) {
		this.storageService = storageService;
	}

	@Autowired
	private ISubElementoService subElementoService;

	@Autowired
	private IElementoService elementoService;

	@Autowired
	private IValidacionDetalleService validacionDetalleService;

	@Autowired
	private IValidacionService validacionService;


	@RequestMapping(value = { "/content_sections" }, method = RequestMethod.GET)
	public String content_sections(Model model) {
		model.addAttribute("elementos", elementoService.findAll());
		model.addAttribute("cabecera", "Documentacion y Validaciones");
		return "/validacion/content_sections";
	}

	@RequestMapping(value = "/content_sections/aplicar_cambios", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> aplicarCambios(Validacion validacion) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (validacion == null) {
			return map;
		}
		Date fecha_actual = new Date();
		String revision = validacion.getRevision();
		String titulo = validacion.getRevision();
		String ayuda = validacion.getAyuda();
		String detalle = validacion.getDetalle();
		String descripcion = validacion.getDescripcion().replace("\n", " ").replace("\t", " ");

		if (validacion.getIdrevisionValidacion() != 0) {
			validacion = validacionService.findOne(validacion.getIdrevisionValidacion());
		} else {
			validacion.setFechaCreacion(fecha_actual);
			validacion.setFechaDesactivacion(fecha_actual);
			validacion.setEstado(Boolean.TRUE);
		}
		validacion.setRevision(revision);
		validacion.setTitulo(titulo);
		validacion.setDescripcion(descripcion);
		validacion.setDetalle(detalle);
		validacion.setAyuda(ayuda);

		if (!validacion.getValidacionDetalleList().isEmpty()) {
			for (int index = 0; index < validacion.getValidacionDetalleList().size(); index++) {
				ValidacionDetalle vd = validacion.getValidacionDetalleList().get(index);
				vd.setUltimoCambio(Boolean.FALSE);
				validacion.getValidacionDetalleList().set(index, vd);
			}

		}

		ValidacionDetalle validacionDetalle = new ValidacionDetalle();
		validacionDetalle.setFechaModificacion(fecha_actual);
		validacionDetalle.setFechaMoficacionDate(fecha_actual);
		validacionDetalle.setIdusuario(new Usuario(3));
		validacionDetalle.setUltimoCambio(Boolean.TRUE);
		validacionDetalle.setIdvalidacion(validacion);
		validacion.getValidacionDetalleList().add(validacionDetalle);
		validacionService.save(validacion);
		map.put("hola", "hola");

		return map;

	}

	@RequestMapping(value = "/content_sections/section_load/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> load_section(@PathVariable(value = "id") Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Validacion validacion = validacionService.findOne(id);
		map.put("revision", validacion.getRevision());
		map.put("detalle", validacion.getDetalle());
		map.put("ayuda", validacion.getAyuda());
		return map;

	}

	@RequestMapping(value = "/content_sections/disabled_detail", method = RequestMethod.GET)
	public String disabled_section(@RequestParam(value = "id") Integer id,
			@SessionAttribute(required = false) String title, @SessionAttribute Boolean otherQuery,
			@SessionAttribute Integer page_number, @SessionAttribute SubElemento subElemento, Model model) {

		Validacion validacion = validacionService.findOne(id);
		validacion.setEstado(Boolean.FALSE);
		validacionService.save(validacion);
		Pageable pageRequest = PageRequest.of(page_number, 6);
		Page<ValidacionDetalle> validacionDetalle = ((otherQuery == true)
				? validacionDetalleService.findByDetalleEstadoTitle(Boolean.TRUE, validacion.getIdsubelemento().getIdsubelemento(), title, pageRequest)
				: validacionDetalleService.findByDetalleEstado(Boolean.TRUE, validacion.getIdsubelemento().getIdsubelemento(), pageRequest));
		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>(
				"/content_sections/disabled_detail", validacionDetalle);

		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		model.addAttribute("subElemento", subElemento);
		model.addAttribute("page_number", page_number);
		return "/validacion/section_detalle";

	}

	@RequestMapping(value = { "/content_sections/section" }, method = RequestMethod.GET)
	public String section(@RequestParam(value = "id") Integer id, Model model) {
		SubElemento subElemento = subElementoService.findOne(id);
		Pageable pageRequest = PageRequest.of(0, 6);
		Page<ValidacionDetalle> validacionDetalle = validacionDetalleService.findByDetalleEstado(Boolean.TRUE,
				subElemento.getIdsubelemento(), pageRequest);
		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>("/content_sections/section",
				validacionDetalle);
		model.addAttribute("subElemento", subElemento);
		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		model.addAttribute("otherQuery", false);
		model.addAttribute("title", null);

		return "/validacion/section";
	}

	@RequestMapping(value = { "/content_sections/section_search" }, method = RequestMethod.GET)
	public String section_search(@RequestParam(value = "title") String title, @SessionAttribute SubElemento subElemento,
			Model model) {
		// SubElemento subElemento = subElementoService.findOne(id);
		Pageable pageRequest = PageRequest.of(0, 6);
		Page<ValidacionDetalle> validacionDetalle = validacionDetalleService.findByDetalleEstadoTitle(Boolean.TRUE,
				subElemento.getIdsubelemento(), title, pageRequest);
		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>("/content_sections/section_search",
				validacionDetalle);
		model.addAttribute("subElemento", subElemento);
		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		model.addAttribute("otherQuery", true);

		model.addAttribute("title", title);
		return "/validacion/section";
	}

	@RequestMapping(value = { "/content_sections/listar_detalle" }, method = RequestMethod.GET)
	public String listar_detalle(@RequestParam(value = "id") Integer id, @SessionAttribute Boolean otherQuery,
			@SessionAttribute SubElemento subElemento, @SessionAttribute Integer page_number, Model model) {

		if (otherQuery) {
			page_number = 0;
		}

		Pageable pageRequest = PageRequest.of(page_number, 6);
		Page<ValidacionDetalle> validacionDetalle = validacionDetalleService.findByDetalleEstado(Boolean.TRUE, id,
				pageRequest);

		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>("/content_sections/listar_detalle",
				validacionDetalle);

		// codigo repetitivo
		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		model.addAttribute("subElemento", subElemento);
		model.addAttribute("otherQuery", false);
		model.addAttribute("title", null);
		return "/validacion/section_detalle";

	}

	@RequestMapping(value = { "/content_sections/listar_detalle_page" }, method = RequestMethod.GET)
	public String listar_detalle_page(@RequestParam(value = "id") Integer id, @SessionAttribute SubElemento subElemento,
			@SessionAttribute(required = false) Boolean otherQuery, @SessionAttribute(required = false) String title,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page, Model model) {


		Pageable pageRequest = PageRequest.of(page, 6);

		Page<ValidacionDetalle> validacionDetalle = ((otherQuery == true)
				? validacionDetalleService.findByDetalleEstadoTitle(Boolean.TRUE, id, title, pageRequest)
				: validacionDetalleService.findByDetalleEstado(Boolean.TRUE, id, pageRequest));

		PageRender<ValidacionDetalle> pageRender = new PageRender<ValidacionDetalle>(
				"/content_sections/listar_detalle_page", validacionDetalle);

		model.addAttribute("detalleValidacion", validacionDetalle);
		model.addAttribute("page", pageRender);
		model.addAttribute("subElemento", subElemento);
		model.addAttribute("page_number", page);
		return "/validacion/section_detalle";

	}

	@RequestMapping(value = { "/contents/image_uploads" }, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> image_upload(@RequestParam("file") MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		storageService.store(file);

		map.put("files",
				storageService.loadAll()
						.map(path -> MvcUriComponentsBuilder
								.fromMethodName(ValidacionDetalleController.class, "serveFile", path.getFileName().toString())
								.build().toString())
						.collect(Collectors.toList())

		);

		return map;

	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}

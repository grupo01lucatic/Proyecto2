package com.grupo01.proyecto.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.grupo01.proyecto.model.Persona;
import com.grupo01.proyecto.services.IPersonaServices;
import com.grupo01.proyecto.model.Provincia;
import com.grupo01.proyecto.model.Telefono;
import com.grupo01.proyecto.services.IProvinciaService;

/**
 * Clase HomeController. Esta clase es la controladora de la vista. 14/05/2019
 * 
 * @version 1.0
 * @author Santiago Villar
 *
 */
@Controller
@SessionAttributes("persona")
public class HomeController {
	@Autowired
	private IProvinciaService provinciaservice;
	@Autowired
	private IPersonaServices personaservice;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * @return Devuelve la pagina principal.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		logger.info("-- iniciada pagina de bienvenida");
		return "index";
	}

	/**
	 * 1 * Descripcion: controller 2 * Fecha: 16.05.2019 3 * @version 1.0 4
	 * * @author Santiago Villar * @return Devuelve a la pagina crear usuario nuevo
	 */

	@RequestMapping(value = "/iracreateuser", method = RequestMethod.GET)
	public String createuser() {
		logger.info("-- iniciada pagina de contacto nuevo");
		return "redirect:/createContacto";
	}

	/**
	 * 1 * Descripcion: controller 2 * Fecha: 16.05.2019 3 * @version 1.0 4
	 * * @author Santiago Villar * @return Devuelve a la pagina listado de contactos
	 */
	@RequestMapping(value = "/iraListarContacto", method = RequestMethod.GET)
	public String listarContactos() {
		logger.info("-- iniciada pagina de listado de contacto");
		return "redirect:/ListarContactos";
	}

	/**
	 * 1 * Descripcion: controller 2 * Fecha: 16.05.2019 3 * @version 1.0 4
	 * * @author Grupo01 5 * @return Devuelve a la pagina listado de contactos
	 */
	@RequestMapping(value = "/iraListarProvincia", method = RequestMethod.GET)
	public String listarProvincias() {
		logger.info("-- iniciada pagina de listado de provincia");
		return "redirect:/ListarProvincias";
	}

	/**
	 * @author Ivan Carpio Fecha: 14.05.2019 GET Descripcion: Recibe un objeto de
	 *         tipo Persona y lo añade al Map del modelo Persona
	 * @version 1.0
	 */
	@RequestMapping(value = "/createContacto", method = RequestMethod.GET)
	public String crear(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("telefono", new Telefono());
		Iterable<Provincia> provincias = provinciaservice.findAll();
		model.addAttribute("provincias", provincias);
		logger.info("-- iniciada pagina de crear contacto");
		return "CrearContacto";
	}

	/**
	 * @author Ivan Carpio Fecha: 14.05.2019 Descripcion: Inserta un contacto nuevo
	 *         a la base de datos cuando pulsas el boton Crear de la vista
	 *         createuser.Si hay algun error retorna al formulario y si todo es
	 *         correcto redirige a la raiz.
	 * @version 1.0
	 */
	@RequestMapping(value = "/createContacto", method = RequestMethod.POST)
	// @Valid, BindingResult necesarios para validar los campos
	public String guardar(@ModelAttribute Persona persona, BindingResult result, Model model, SessionStatus status) {
		personaservice.save(persona);
		status.setComplete();
		logger.info("-- creado contacto");
		return "redirect:/";
	}

	/**
	 * @author Ivan Carpio Fecha: 14.05.2019 Descripcion: Muestra todos los datos
	 *         asociados al contacto, que coincida con la id y los inyecta en la
	 *         vista /Detalle/id ,el titulo de la pagina y el nombre del contacto en
	 *         la pestaña.
	 * @version 1.0
	 */

	@RequestMapping(value = "/Detalle/{id}") // En la vista tiene que que llevar
	public String Detalle(@PathVariable(value = "id") int id, Map<String, Object> model) {
		Persona persona = null;

		if (id > 0) {
			persona = personaservice.findOne(id);
		} else {
			return "redirect:/";
		}
		model.put("persona", persona);
		model.put("titulo", "Detalles del Contacto");
		logger.info("-- iniciada pagina de detalle de contacto");

		return "DetalleContacto";
	}

	/**
	 * @author Jara Dominguez Fecha: 16.05.2019 Llama a un metodo en servicios que
	 *         tiene una lista de contacto y muestra la lista en el html
	 *         ListarContactos
	 * @version 1.0
	 */

	/**
	 * @author Sagui Shahnavaz Fecha: 20.05.2019 Buscador en la lista contactos
	 * @version 1.0
	 */
	@GetMapping("/ListarContactos")
	public String listarContacto(Model model,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		Iterable<Persona> personas;

		if (search.trim().length() > 0) {
			personas = personaservice.findByNameOrPhone(search);
		} else {
			personas = personaservice.findAll();
		}

		model.addAttribute("personas", personas);

		logger.info("Se han mostrado los contactos");
		return "ListarContactos";
	}

	/**
	 * @author Santiago Villar Calvo: 16.05.2019 Recoge la id del usuario a editar y
	 *         muestra sus datos
	 * @version 1.0
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editarContacto(@PathVariable(value = "id") Integer id, Model model) {
		Persona persona = personaservice.findOne(id);
		model.addAttribute("persona", persona);
		Iterable<Provincia> provincias = provinciaservice.findAll();
		model.addAttribute("provincias", provincias);
		logger.info("-- iniciada pagina de editar contacto");
		return "EditarContacto";
	}

	/**
	 * @author Saghi: 16.05.2019 Sobreescribe el usuario en la DB.
	 * @version 1.0
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editar(@ModelAttribute Persona persona, BindingResult result, Model model, SessionStatus status) {
		personaservice.save(persona);
		status.setComplete();
		logger.info("-- Se ha editado el contacto correctamente");
		return "redirect:/";
	}

	/**
	 * Metodo para eliminar un contacto al darle click en el boton que llama al
	 * metodo en servicio que usa el id del contacto para eliminarlo.
	 * 
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @param model
	 * @param id
	 * @return Manda a la vista de listado de contactos
	 */

	@GetMapping("/delete/{id}")
	public String eliminarContacto(@PathVariable Integer id) {
		personaservice.delete(id);
		logger.info("Se ha borrado el contacto");
		return "redirect:/ListarContactos";
	}

	/**
	 * Metodo para mostrar la vista de todas las provincias disponibles que llama a
	 * provinciaservice.
	 * 
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @param model
	 * @return Manda a la vista de listado de provincias
	 */

	@GetMapping("/ListarProvincias")
	public String listarProvincias(Model model) {
		model.addAttribute("provincias", provinciaservice.findAll());
		logger.info("Se han listado las provincias");
		return "ListarProvincias";
	}

	/**
	 * Metodo para mostrar la vista de alta provincia
	 * 
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @return Manda a la vista de alta provincia
	 */
	@GetMapping("/irAltaProvincias")
	public String createProvincia() {
		logger.info("--Iniciada pagina para provincia nueva");
		return "redirect:/CrearProvincias";
	}

	/**
	 * Carga el formulario en la pagina
	 * 
	 * @author Santiago Villar
	 * @date 16.05.2019
	 * @return Devuelve la pagina del formulario para crear provincias
	 */

	@RequestMapping(value = "/createProvincia", method = RequestMethod.GET)
	public String crearProvincia(Model model) {
		model.addAttribute("provincia", new Provincia());
		return "CrearProvincia";
	}

	/**
	 * Guarda la provincia introducida por el usuario en el formulario
	 * 
	 * @author Jara Dominguez
	 * @date 16.05.2019
	 * @return Redirecciona a la pagina que muestra el listado de provincias
	 */
	@PostMapping("/createProvincia")
	public String guardarProvincia(@Valid Provincia provincia, BindingResult result, Model model,
			SessionStatus status) {
		provinciaservice.save(provincia);
		status.setComplete();
		logger.info("Se ha creado la provincia");
		return "redirect:/ListarProvincias";
	}

	/**
	 * Muestra los detalles de una provincia
	 * 
	 * @author Ivan Carpio
	 * @date 16.05.2019
	 * @return Redirecciona a la pagina que muestra el detalle de provincias
	 */
	@RequestMapping(value = "/DetalleProvincia/{id}")
	public String detalleProvincia(@PathVariable(value = "id") int id, Map<String, Object> model) {
		Provincia provincia = null;

		if (id > 0) {
			provincia = provinciaservice.findOne(id);
		} else {
			return "redirect:/Index";
		}
		model.put("provincias", provincia);
		return "DetalleProvincia";
	}
}

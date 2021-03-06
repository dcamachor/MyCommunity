package com.proyecto.mycommunity.controllers;


import java.util.Collection;
import java.util.Map;

import com.proyecto.mycommunity.models.entity.Persona;
import com.proyecto.mycommunity.util.paginator.PageRender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.mycommunity.models.service.IPersonaService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes("persona")
public class PersonaController {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private IPersonaService personaService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/ver/{rut}")
    public String ver(@PathVariable(value = "rut") int rut, Map<String, Object> model, RedirectAttributes flash) {

        Persona persona = personaService.fetchByIdWithFacturas(rut);
        if (persona == null) {
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }
        model.put("persona", persona);
        model.put("titulo", "Detalle cliente: " + persona.getNombre());
        return "ver";
    }

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model, Authentication authentication, HttpServletRequest request) {

        if (authentication != null) {
            logger.info("Hola usuario autenticado, tu user es: ".concat(authentication.getName()));
        }

        if (hasRole("ROLE_ADMIN")) {
            logger.info("Hola ".concat(authentication.getName().concat(" tienes acceso!")));
        } else {
            logger.info("Hola  ".concat(authentication.getName().concat(" NO tienes acceso!")));
        }

        Pageable pageRequest = PageRequest.of(page, 10);

        Page<Persona> personas = personaService.findAll(pageRequest);

        PageRender<Persona> pageRender = new PageRender<Persona>("/listar", personas);
        model.addAttribute("titulo", "Listado de Personas");
        model.addAttribute("personas", personas);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    @GetMapping(value = {"/home", "/"})
    public String ingresar(Model model) {
        model.addAttribute("titulo", "Bienvenido a My Community");
        return "home";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Persona persona = new Persona();
        model.put("persona", persona);
        model.put("titulo", "Formulario de Persona");
        return "form";
    }

    @RequestMapping(value = "/form/{rut}")
    public String editar(@PathVariable(value = "rut") int rut, Map<String, Object> model, RedirectAttributes flash) {

        Persona persona = null;

        if (rut > 0) {
            persona = personaService.findOne(rut);
            if (persona == null) {
                flash.addFlashAttribute("error", "El rut de la Persona no existe en la BBDD!");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El rut de la Persona no puede ser cero!");
            return "redirect:/listar";
        }
        model.put("persona", persona);
        model.put("titulo", "Editar Persona");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Persona persona, BindingResult result, Model model,/* @RequestParam("file") MultipartFile foto,*/ RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Persona");
            return "form";
        }

        String mensajeFlash = (persona.getRut() == 0) ? "Persona creada con éxito!" : "Persona editada con éxito!";

        personaService.save(persona);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listar";
    }

    @RequestMapping(value = "/eliminar/{rut}")
    public String eliminar(@PathVariable(value = "rut") int rut, RedirectAttributes flash) {

        if (rut > 0) {
            Persona persona = personaService.findOne(rut);

            personaService.delete(rut);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
        }
        return "redirect:/listar";
    }

    private boolean hasRole(String role) {
        SecurityContext context = SecurityContextHolder.getContext();

        if (context == null) {
            return false;
        }

        Authentication authentication = context.getAuthentication();
        if (context == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return authorities.contains(new SimpleGrantedAuthority(role));

       /* for (GrantedAuthority authority : authorities) {
            if (role.equals(authority.getAuthority())) {
                logger.info("Hola Usuario ".concat(authentication.getName().concat(" tu role es: ".concat(authority.getAuthority()))));
                return false;
            }
        }
        return false;


        */
    }

}
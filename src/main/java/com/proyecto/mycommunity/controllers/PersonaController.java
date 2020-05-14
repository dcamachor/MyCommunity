package com.proyecto.mycommunity.controllers;

import java.net.MalformedURLException;
import java.util.Map;

import com.proyecto.mycommunity.models.entity.Persona;
import com.proyecto.mycommunity.models.service.IUploadFileService;
import com.proyecto.mycommunity.util.paginator.PageRender;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.mycommunity.models.service.IPersonaService;

@Controller
@SessionAttributes("persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IUploadFileService uploadFileService;
/*
    @GetMapping(value = "/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

        Resource recurso = null;

        try {
            recurso = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);
    }
*/
    @GetMapping(value = "/ver/{rut}")
    public String ver(@PathVariable(value = "rut") int rut, Map<String, Object> model, RedirectAttributes flash) {

        Persona persona = personaService.findOne(rut);
        if (persona == null) {
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }
        model.put("cliente", persona);
        model.put("titulo", "Detalle cliente: " + persona.getNombre());
        return "ver";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 4);

        Page<Persona> personas = personaService.findAll(pageRequest);

        PageRender<Persona> pageRender = new PageRender<Persona>("/listar", personas);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("personas", personas);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Persona persona = new Persona();
        model.put("persona", persona);
        model.put("titulo", "Formulario de Persona");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
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

    /* para agregar fotos
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Persona persona, BindingResult result, Model model,
            @RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Persona");
            return "form";
        }

        if (!foto.isEmpty()) {

            if (persona.getRut() != null && persona.getRut() > 0 && persona.getFoto() != null
                    && persona.getFoto().length() > 0) {

                uploadFileService.delete(cliente.getFoto());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy(foto);
            } catch (IOException e) {
                e.printStackTrace();
            }

            flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");

            cliente.setFoto(uniqueFilename);
        }

        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

        personaService.save(cliente);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listar";
    }
    */
    @RequestMapping(value = "/eliminar/{rut}")
    public String eliminar(@PathVariable(value = "rut") int rut, RedirectAttributes flash) {

        if (rut > 0) {
            Persona persona = personaService.findOne(rut);

            personaService.delete(rut);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
        /* para eliminar foto
            if (uploadFileService.delete(persona.getFoto())) {
                flash.addFlashAttribute("info", "Foto " + cliente.getFoto() + " eliminada con exito!");
            }
*/
        }
        return "redirect:/listar";
    }
}
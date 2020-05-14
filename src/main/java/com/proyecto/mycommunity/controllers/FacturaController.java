package com.proyecto.mycommunity.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.proyecto.mycommunity.models.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.mycommunity.models.service.IPersonaService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

    @Autowired
    private IPersonaService personaService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        Factura factura = personaService.findFacturaById(id);

        if (factura == null) {
            flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
            return "redirect:/listar";
        }

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));

        return "factura/ver";
    }

    @GetMapping("/form/{personaId}")
    public String crear(@PathVariable(value = "personaId") Integer personaId, Map<String, Object> model,
                        RedirectAttributes flash) {

        Persona persona = personaService.findOne(personaId);

        if (persona == null) {
            flash.addFlashAttribute("error", "La Persona no existe en la base de datos");
            return "redirect:/listar";
        }

        Factura factura = new Factura();
        factura.setPersona(persona);

        model.put("factura", factura);
        model.put("titulo", "Crear Factura");

        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
    public @ResponseBody
    List<Producto> cargarProductos(@PathVariable String term) {
        return personaService.findByNombre(term);
    }

    @PostMapping("/form")
    public String guardar(@Valid Factura factura,
                          BindingResult result, Model model,
                          @RequestParam(name = "item_id[]", required = false) Long[] itemId,
                          @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
                          RedirectAttributes flash,
                          SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear Factura");
            return "factura/form";
        }

        if (itemId == null || itemId.length == 0) {
            model.addAttribute("titulo", "Crear Factura");
            model.addAttribute("error", "Error: La factura NO puede no tener líneas!");
            return "factura/form";
        }

        for (int i = 0; i < itemId.length; i++) {
            Producto producto = personaService.findProductoById(itemId[i]);

            ItemFactura linea = new ItemFactura();
            linea.setCantidad(cantidad[i]);
            linea.setProducto(producto);
            factura.addItemFactura(linea);

            log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
        }

        personaService.saveFactura(factura);
        status.setComplete();

        flash.addFlashAttribute("success", "Factura creada con éxito!");

        return "redirect:/ver/" + factura.getPersona().getRut();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        Factura factura = personaService.findFacturaById(id);

        if (factura != null) {
            personaService.deleteFactura(id);
            flash.addFlashAttribute("success", "Factura eliminada con éxito!");
            return "redirect:/ver/" + factura.getPersona().getRut();
        }
        flash.addFlashAttribute("error", "La factura no existe en la base de datos, no se pudo eliminar!");

        return "redirect:/listar";
    }

}

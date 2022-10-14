package com.proyecto.agendalab.agendalab.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.agendalab.agendalab.controller.dto.ExamenDto;
import com.proyecto.agendalab.agendalab.service.ExamenService;
import com.proyecto.agendalab.agendalab.service.SeccionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Controller
@Slf4j
public class AgendaLabController {

    private SeccionService seccionService;
    private ExamenService examenService;

    @GetMapping(value = { "", "/", "/index", "/index.html" })
    public String goToIndex(Model model) {
        return "index";
    }

    @GetMapping("/admin")
    public String goToAdmin(Model model) {
        return "admin";
    }

    @PostMapping("/adminAgregar")
    public String postExamenRegistro(@ModelAttribute ExamenDto examenInfo, Model model) {
        model.addAttribute("exam", "Parametrización de exámenes");

        examenService.guardarExamen(examenInfo);

        model.addAttribute("info", examenInfo);

        var secciones = this.seccionService.getSecciones();

        model.addAttribute("secciones", secciones);

        return "adminAgregar";

    }

    @PostMapping("/adminEditar")
    public String postEditarExamen(@ModelAttribute ExamenDto examenInfo, Model model) {
        model.addAttribute("exam", "Parametrización de exámenes");

        examenService.editarExamen(examenInfo);

        return "redirect:adminlist";
    }

    @GetMapping("/Agregar")
    public String goToAdminAgregar(Model model) {
        model.addAttribute("exam", "Parametrización de exámenes");

        var secciones = this.seccionService.getSecciones();

        model.addAttribute("secciones", secciones);

        return "adminAgregar";
    }

    @GetMapping(value = {"adminlist"})
    public String goToAdminList(Model model) {
        model.addAttribute("list", "Parametrización de exámenes");

        List<ExamenDto> examenes = examenService.listarExamenes();
        
        // log.info(examenes.toString());
        //var secciones = this.seccionService.getSecciones();

        //var nSecciones = examenes.stream().map(ex -> this.seccionService.getNombre(ex.getSeccion())).collect(Collectors.toList());

        //log.info(nSecciones.toString());

        //model.addAttribute("secciones", nSecciones);

        model.addAttribute("examenes", examenes);

        return "adminlist";
    }

    @GetMapping("/eliminar/{cups}")
    public String borrarExamen(Model model, @PathVariable Long cups) {
        examenService.borrarExamen(cups);
        
        return "redirect:adminlist";
    }

    @GetMapping("/contactenos")
    public String goToContactenos(Model model) {
        return "contactenos";
    }

    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

    @GetMapping("/registro")
    public String goToRegistro(Model model) {
        return "registro";
    }

    @GetMapping("/servicios")
    public String goToServicios(Model model) {
        return "servicios";
    }

    @GetMapping("/usuario")
    public String goToUsuario(Model model) {
        return "usuario";
    }

}


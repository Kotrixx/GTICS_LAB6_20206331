package com.example.lab6.controller;

import com.example.lab6.repository.SitioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sitios")
public class SitioController {
    final SitioRepository sitioRepository;

    public SitioController(SitioRepository sitioRepository) {
        this.sitioRepository = sitioRepository;
    }

    @GetMapping(value = {"","listar"})
    public String listarSitios(Model model){
        model.addAttribute("listaSitio", sitioRepository.findAll());

        return "sitios/list";
    }
}

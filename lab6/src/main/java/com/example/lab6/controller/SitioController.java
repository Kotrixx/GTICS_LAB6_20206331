package com.example.lab6.controller;

import com.example.lab6.entity.Site;
import com.example.lab6.repository.LocationRepository;
import com.example.lab6.repository.SitioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/sitios")
public class SitioController {
    final SitioRepository sitioRepository;
    final LocationRepository locationRepository;
    public SitioController(SitioRepository sitioRepository, LocationRepository locationRepository) {
        this.sitioRepository = sitioRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping(value = {"","listar"})
    public String listarSitios(Model model){
        model.addAttribute("listaSitio", sitioRepository.findAll());

        return "sitios/list";
    }

    @GetMapping("/nuevo")
    public String nuevoSitio(Model model) {
        model.addAttribute("listaLocations", locationRepository.obtenerComboBoxSitio());
        return "sitios/newFrm";
    }
    @GetMapping("/borrar")
    public String borrarTransportista(@RequestParam("id") int id, RedirectAttributes attributes) {

        Optional<Site> optionalSite = sitioRepository.findById(id);

        if (optionalSite.isPresent()) {
            Site site = optionalSite.get();
            String siteName = site.getSiteName();
            sitioRepository.deleteById(id);
            attributes.addFlashAttribute("msg", "Sitio " +siteName+ " borrado exitosamente");
        }
        return "redirect:/sitios";

    }
    @PostMapping("/guardarNuevo")
    public String guardarNuevoSitio(Site site, RedirectAttributes attr) {
        attr.addFlashAttribute("msg", "Sitio " + site.getSiteName() + " creado correctamente");
        sitioRepository.save(site);
        return "redirect:/sitios";
    }
}

package com.example.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/stats")
public class EstadisticaController {
    @RequestMapping(value = "")
    public String main(){
        return "estadisticas";
    }
}

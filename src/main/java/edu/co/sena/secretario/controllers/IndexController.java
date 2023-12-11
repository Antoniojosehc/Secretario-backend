package edu.co.sena.secretario.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class IndexController {

    @GetMapping(path = "/")
    public String saludar() {
        return "Hola probando";
    }

}

package edu.co.sena.secretario.controllers;

import edu.co.sena.secretario.contracts.UsuarioDto;
import edu.co.sena.secretario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public String register(@RequestBody UsuarioDto request) {
        this.service.register(request);
        return "Usuario registrado con éxito";
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto request) {
        boolean isValid = this.service.login(request);
        return isValid ? "Login exitoso" : "Usuario o contraseña incorrectos";
    }
}

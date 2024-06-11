package edu.co.sena.secretario.controllers;

import edu.co.sena.secretario.contracts.InformeMensualDto;
import edu.co.sena.secretario.services.InformeMensualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/informeMensual")
public class InformeMensualController {

    @Autowired
    private InformeMensualService service;

    @PostMapping()
    public String create(@RequestBody InformeMensualDto request) {
        this.service.create(request);
        return "ok";
    }

    @GetMapping
    public List<InformeMensualDto> getAll() {
        return this.service.getAllInformes();
    }

    @GetMapping(path = "/{idPublicador}/{anio}/{mes}")
    public InformeMensualDto getById(@PathVariable("idPublicador") Long idPublicador, @PathVariable("anio") int anio, @PathVariable("mes") String mes) {
        return this.service.getById(idPublicador, anio, mes);
    }

    @PutMapping(path = "/{idPublicador}/{anio}/{mes}")
    public String update(@PathVariable("idPublicador") Long idPublicador, @PathVariable("anio") int anio, @PathVariable("mes") String mes, @RequestBody InformeMensualDto request) {
        this.service.update(request, idPublicador, anio, mes);
        return "ok";
    }

    @DeleteMapping(path = "/{idPublicador}/{anio}/{mes}")
    public String delete(@PathVariable("idPublicador") Long idPublicador, @PathVariable("anio") int anio, @PathVariable("mes") String mes) {
        this.service.delete(idPublicador, anio, mes);
        return "ok";
    }

    @GetMapping("/publicador/{idPublicador}")
    public List<InformeMensualDto> getInformesByPublicador(@PathVariable("idPublicador") Long idPublicador) {
        return this.service.getInformesByPublicador(idPublicador);
    }
}

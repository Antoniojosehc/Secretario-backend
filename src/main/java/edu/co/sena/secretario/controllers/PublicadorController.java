package edu.co.sena.secretario.controllers;

import edu.co.sena.secretario.contracts.PublicadorDto;
import edu.co.sena.secretario.services.PublicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicador")
public class PublicadorController {

    @Autowired
    private PublicadorService service;

    @PostMapping()
    public String create(@RequestBody PublicadorDto request) {
        this.service.create(request);
        return "ok";
    }

    @GetMapping
    public List<PublicadorDto> getAll(){
        return this.service.getAllPublicadores();
    }

    @GetMapping(path = "/{id}")
    public PublicadorDto getById(@PathVariable("id") Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody PublicadorDto request){
        this.service.update(request, id);
        return "ok";
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        this.service.delete(id);
        return "ok";
    }


}

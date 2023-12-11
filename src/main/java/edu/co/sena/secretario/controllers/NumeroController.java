package edu.co.sena.secretario.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/numero")
public class NumeroController {
    private ArrayList<Integer> numeros = new ArrayList<>();

    @GetMapping(path ="/")
    public String getNumero() {

        return "Los números ingresados son: " + numeros.toString();
    }

    @GetMapping(path = "/{index}")
    public String getNumeroPorIndex(@PathVariable("index") String i){
        int idx = Integer.parseInt(i);
        return "El número consultado es: " + numeros.get(idx);
    }

    @PostMapping(path = "/")
    public String addNumero(@RequestBody String data) {
        int newNumero = Integer.parseInt(data);
        this.numeros.add(newNumero);
        return "Número agregado: " + data +
                ". la cantidad de números es: " + this.numeros.size();

    }

    @PutMapping(path = "/{index}")
    public String actualizarNumero(
            @PathVariable("index") String i,
            @RequestBody String data) {
        int idx = Integer.parseInt(i);
        int newNumero = Integer.parseInt(data);
        this.numeros.set(idx, newNumero);
        return "La posición " + idx + " fue actualizada con el valor: " + newNumero;

    }

    @DeleteMapping(path = "/{index}")
    public String eliminarNumero(@PathVariable("index") String i) {
        int idx = Integer.parseInt(i);
        this.numeros.remove(idx);
        return "El número en la posición " + idx + " fue eliminado";
    }

}

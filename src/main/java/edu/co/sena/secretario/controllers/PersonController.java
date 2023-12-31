package edu.co.sena.secretario.controllers;

import edu.co.sena.secretario.contracts.PersonDto;
import edu.co.sena.secretario.contracts.ResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonController {

    private List<PersonDto> personas = new ArrayList<>();

    @GetMapping()
    public List<PersonDto> getPerson(){
        return personas;
    }


    @PostMapping()
    public ResponseDto<String> createPerson(@RequestBody PersonDto request){
        this.personas.add(request);

        ResponseDto<String> response = new ResponseDto<>();
        response.setData("Ok");
        return response;
    }



}

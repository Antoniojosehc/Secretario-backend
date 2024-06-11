package edu.co.sena.secretario.services;

import edu.co.sena.secretario.contracts.PublicadorDto;
import edu.co.sena.secretario.entities.PublicadorEntity;
import edu.co.sena.secretario.repositories.PublicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicadorService {

    @Autowired
    private PublicadorRepository repository;

    public void create(PublicadorDto dto){
        PublicadorEntity entity = new PublicadorEntity();

        entity.setFullName(dto.getFullName());
        entity.setBornDate(dto.getBornDate());
        entity.setBaptismDate(dto.getBaptismDate());
        entity.setSex(dto.getSex());
        entity.setNotes(dto.getNotes());

        this.repository.save(entity);
    }

    public List<PublicadorDto> getAllPublicadores(){
        List<PublicadorEntity> publicadores = this.repository.findAll();
        ArrayList<PublicadorDto> dtos = new ArrayList<>();

        for (int i = 0; i < publicadores.size(); i++) {
            PublicadorEntity currentEntity = publicadores.get(i);
            PublicadorDto dto = new PublicadorDto();

            dto.setId(currentEntity.getId());
            dto.setFullName(currentEntity.getFullName());
            dto.setBornDate(currentEntity.getBornDate());
            dto.setBaptismDate(currentEntity.getBaptismDate());
            dto.setSex(currentEntity.getSex());
            dto.setNotes(currentEntity.getNotes());

            dtos.add(dto);

        }

        return dtos;

    }

    public PublicadorDto getById(Long id){
        PublicadorEntity entity = this.repository.findById(id).get();

        PublicadorDto dto = new PublicadorDto();

        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setBornDate(entity.getBornDate());
        dto.setBaptismDate(entity.getBaptismDate());
        dto.setSex(entity.getSex());
        dto.setNotes(entity.getNotes());

        return dto;

    }

    public void update(PublicadorDto dto, Long id){
        PublicadorEntity entity = this.repository.findById(id).get();

        entity.setFullName(dto.getFullName());
        entity.setBornDate(dto.getBornDate());
        entity.setBaptismDate(dto.getBaptismDate());
        entity.setSex(dto.getSex());
        entity.setNotes(dto.getNotes());

        this.repository.save(entity);

    }

    public void delete(Long id){
        PublicadorEntity entity = this.repository.findById(id).get();
        this.repository.deleteById(id);
    }

}
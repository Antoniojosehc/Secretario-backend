package edu.co.sena.secretario.services;

import edu.co.sena.secretario.contracts.InformeMensualDto;
import edu.co.sena.secretario.entities.InformeMensualEntity;
import edu.co.sena.secretario.entities.PublicadorEntity;
import edu.co.sena.secretario.entities.InformeMensualId;
import edu.co.sena.secretario.repositories.InformeMensualRepository;
import edu.co.sena.secretario.repositories.PublicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformeMensualService {

    @Autowired
    private InformeMensualRepository informeMensualRepository;

    @Autowired
    private PublicadorRepository publicadorRepository;

    public void create(InformeMensualDto dto) {
        InformeMensualEntity entity = new InformeMensualEntity();

        entity.setAnio(dto.getAnio());
        entity.setMes(dto.getMes());
        entity.setPublicaciones(dto.getPublicaciones());
        entity.setVideos(dto.getVideos());
        entity.setHoras(dto.getHoras());

        PublicadorEntity publicador = publicadorRepository.findById(dto.getIdPublicador()).orElseThrow(() -> new RuntimeException("Publicador no encontrado"));
        entity.setPublicador(publicador);

        informeMensualRepository.save(entity);
    }

    public List<InformeMensualDto> getAllInformes() {
        List<InformeMensualEntity> informes = informeMensualRepository.findAll();
        List<InformeMensualDto> dtos = new ArrayList<>();

        for (InformeMensualEntity entity : informes) {
            InformeMensualDto dto = new InformeMensualDto();
            dto.setAnio(entity.getAnio());
            dto.setMes(entity.getMes());
            dto.setPublicaciones(entity.getPublicaciones());
            dto.setVideos(entity.getVideos());
            dto.setHoras(entity.getHoras());
            dto.setIdPublicador(entity.getPublicador().getId());

            dtos.add(dto);
        }

        return dtos;
    }

    public InformeMensualDto getById(Long idPublicador, int anio, String mes) {
        InformeMensualId informeMensualId = new InformeMensualId(anio, mes, idPublicador);
        InformeMensualEntity entity = informeMensualRepository.findById(informeMensualId).orElseThrow(() -> new RuntimeException("Informe mensual no encontrado"));

        InformeMensualDto dto = new InformeMensualDto();
        dto.setAnio(entity.getAnio());
        dto.setMes(entity.getMes());
        dto.setPublicaciones(entity.getPublicaciones());
        dto.setVideos(entity.getVideos());
        dto.setHoras(entity.getHoras());
        dto.setIdPublicador(entity.getPublicador().getId());

        return dto;
    }

    public void update(InformeMensualDto dto, Long idPublicador, int anio, String mes) {
        InformeMensualId informeMensualId = new InformeMensualId(anio, mes, idPublicador);
        InformeMensualEntity entity = informeMensualRepository.findById(informeMensualId).orElseThrow(() -> new RuntimeException("Informe mensual no encontrado"));

        entity.setPublicaciones(dto.getPublicaciones());
        entity.setVideos(dto.getVideos());
        entity.setHoras(dto.getHoras());

        PublicadorEntity publicador = publicadorRepository.findById(dto.getIdPublicador()).orElseThrow(() -> new RuntimeException("Publicador no encontrado"));
        entity.setPublicador(publicador);

        informeMensualRepository.save(entity);
    }

    public void delete(Long idPublicador, int anio, String mes) {
        InformeMensualId informeMensualId = new InformeMensualId(anio, mes, idPublicador);
        informeMensualRepository.deleteById(informeMensualId);
    }

    public List<InformeMensualDto> getInformesByPublicador(Long idPublicador) {
        List<InformeMensualEntity> informes = informeMensualRepository.findByPublicadorId(idPublicador);
        List<InformeMensualDto> dtos = new ArrayList<>();

        for (InformeMensualEntity entity : informes) {
            InformeMensualDto dto = new InformeMensualDto();
            dto.setAnio(entity.getAnio());
            dto.setMes(entity.getMes());
            dto.setPublicaciones(entity.getPublicaciones());
            dto.setVideos(entity.getVideos());
            dto.setHoras(entity.getHoras());
            dto.setIdPublicador(entity.getPublicador().getId());

            dtos.add(dto);
        }

        return dtos;
    }
}

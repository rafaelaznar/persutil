package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.GarciaEntity;
import net.ausiasmarch.persutil.repository.GarciaRepository;

@Service
public class GarciaService {
    
    @Autowired
    GarciaRepository GarciaRepository;

    // ----------------------------CRUD---------------------------------
    public GarciaEntity get(Long id) {
        return GarciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Long create(GarciaEntity garciaEntity) {
    garciaEntity.setFechaInicio(LocalDateTime.now());

    if (garciaEntity.getFechaFinal() == null) {
        garciaEntity.setFechaFinal(LocalDateTime.now().plusDays(1)); // o valor por defecto
    }

    if (garciaEntity.getProgreso() == null || garciaEntity.getProgreso().length() < 5) {
        garciaEntity.setProgreso("Sin progreso");
    }

    GarciaRepository.save(garciaEntity);
    return garciaEntity.getId();
}


    public Long update(GarciaEntity garciaEntity) {
    GarciaEntity existingGarcia = GarciaRepository.findById(garciaEntity.getId())
            .orElseThrow(() -> new RuntimeException("Blog not found"));

    existingGarcia.setTitulo(garciaEntity.getTitulo());
    existingGarcia.setObjetivo(garciaEntity.getObjetivo());

    // Validar progreso mínimo 5 caracteres, o aplicar default
    if (garciaEntity.getProgreso() != null && garciaEntity.getProgreso().length() >= 5) {
        existingGarcia.setProgreso(garciaEntity.getProgreso());
    } else {
        existingGarcia.setProgreso("Sin progreso"); // o valor por defecto
    }

    // No sobreescribir fechas si vienen del frontend
    existingGarcia.setFechaInicio(garciaEntity.getFechaInicio() != null
            ? garciaEntity.getFechaInicio()
            : existingGarcia.getFechaInicio());

    existingGarcia.setFechaFinal(garciaEntity.getFechaFinal() != null
            ? garciaEntity.getFechaFinal()
            : existingGarcia.getFechaFinal());

    GarciaRepository.save(existingGarcia);
    return existingGarcia.getId();
}


    public Long delete(Long id) {
        GarciaRepository.deleteById(id);
        return id;
    }

    public Page<GarciaEntity> getPage(Pageable oPageable) {
        return GarciaRepository.findAll(oPageable);
    }

    public Long count() {
        return GarciaRepository.count();
    }
}

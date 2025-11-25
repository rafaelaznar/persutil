package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.GarciaEntity;
import net.ausiasmarch.persutil.repository.GarciaRepository;

@Service //para que me lo reconozca como servicio
public class GarciaService {
    
    @Autowired
    GarciaRepository GarciaRepository;

    // ----------------------------CRUD---------------------------------
    public GarciaEntity get(Long id) {
        return GarciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Long create(GarciaEntity garciaEntity) {
        garciaEntity.setFechaInicio(LocalDateTime.now());
        garciaEntity.setFechaFinal(null);
        GarciaRepository.save(garciaEntity);
        return garciaEntity.getId();
    }

    public Long update(GarciaEntity garciaEntity) {
        GarciaEntity existingGarcia = GarciaRepository.findById(garciaEntity.getId())
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        existingGarcia.setTitulo(garciaEntity.getTitulo());
        existingGarcia.setObjetivo(garciaEntity.getObjetivo());
        existingGarcia.setFechaInicio(LocalDateTime.now());
        existingGarcia.setFechaFinal(garciaEntity.getFechaFinal());
        
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

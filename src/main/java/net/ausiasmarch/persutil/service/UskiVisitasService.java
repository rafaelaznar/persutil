package net.ausiasmarch.persutil.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.persutil.entity.UskiVisitasEntity;
import net.ausiasmarch.persutil.repository.UskiVisitasRepository;

@Service
public class UskiVisitasService {

    @Autowired
    UskiVisitasRepository oUskiVisitasRepository;

    @Autowired
    AleatorioService oAleatorioService;

    public UskiVisitasEntity get(Long id) {
        if (id == null)
            throw new RuntimeException("Id no puede ser nulo");

        return oUskiVisitasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro de visitas not found"));
    }

    public Long create(UskiVisitasEntity visitasEntity) {
        visitasEntity.setFechaCreacion(LocalDateTime.now());
        visitasEntity.setFechaModificacion(null);
        visitasEntity.setEstaPublicado(false);
        oUskiVisitasRepository.save(visitasEntity);
        return visitasEntity.getId();
    }

    public Long update(UskiVisitasEntity visitasEntity) {
        UskiVisitasEntity existingRegistro = oUskiVisitasRepository.findById(visitasEntity.getId())
                .orElseThrow(() -> new RuntimeException("Libro de visitas not found"));

        boolean nuevoEstado = !existingRegistro.isEstaPublicado();
        existingRegistro.setEstaPublicado(nuevoEstado);
        existingRegistro.setFechaModificacion(LocalDateTime.now());
        oUskiVisitasRepository.save(existingRegistro);
        return existingRegistro.getId();
    }

    public Long delete(Long id) {
        if (id == null)
            throw new RuntimeException("Id no puede ser nulo");

        oUskiVisitasRepository.deleteById(id);
        return id;
    }

    public Page<UskiVisitasEntity> getPage(Pageable oPageable) {
        if (oPageable == null)
            throw new RuntimeException("Page no puede ser nulo");

        return oUskiVisitasRepository.findAll(oPageable);
    }

    public Page<UskiVisitasEntity> getPublishedPage(Pageable oPageable) {
        if (oPageable == null)
            throw new RuntimeException("Page no puede ser nulo");

        return oUskiVisitasRepository.findByEstaPublicadoTrue(oPageable);
    }

    public Long count() {
        return oUskiVisitasRepository.count();
    }

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> comments = new ArrayList<>();

    public UskiVisitasService() {
        names.add("Ana García");
        names.add("Luis Pérez");
        names.add("María López");
        names.add("Javier Ruiz");
        names.add("Elena Soto");
        names.add("Carlos Castro");
        names.add("Andrea Mora");
        names.add("Ricardo Vidal");
        names.add("Sofía Torres");
        names.add("Pablo Herrera");
        names.add("Laura Gil");
        names.add("Diego Núñez");
        names.add("Isabel Ramos");
        names.add("Sergio Martín");
        names.add("Marta Navarro");
        names.add("Jorge Jiménez");

        comments.add("Me encantó el sitio, muy fácil de usar.");
        comments.add("La información está súper clara y bien explicada.");
        comments.add("Volveré a revisar esta página más adelante, me ayudó mucho.");
        comments.add("Funciona rápido y no tuve problemas en navegar.");
        comments.add("El diseño es limpio y agradable a la vista.");
        comments.add("Encontré justo lo que necesitaba, gracias.");
        comments.add("Sería genial añadir más ejemplos prácticos.");
        comments.add("La carga es un poco lenta, pero el contenido lo compensa.");
        comments.add("Muy útil para mis tareas, lo recomiendo.");
        comments.add("Buen trabajo con la estructura, resulta intuitiva.");
        comments.add("Me ayudó a resolver una duda que tenía desde hace días.");
        comments.add("Faltan algunos detalles, pero en general está bien.");
        comments.add("Gracias por actualizar la información tan rápido.");
        comments.add("Me gustaría ver más temas en esta sección.");
        comments.add("Todo funcionó sin errores, buena experiencia.");
        comments.add("Espero que sigan añadiendo contenido nuevo pronto.");
    }

    public Long rellenaBlog(Long numPosts) {
        for (long j = 0; j < numPosts; j++) {

            UskiVisitasEntity visitaEntity = new UskiVisitasEntity();

            visitaEntity.setNombre(
                    names.get(oAleatorioService.GenerarNumeroAleatorioEnteroEnRango(0, comments.size() - 1)));
            visitaEntity.setComentario(
                    comments.get(oAleatorioService.GenerarNumeroAleatorioEnteroEnRango(0, comments.size() - 1)));
            visitaEntity.setFechaCreacion(LocalDateTime.now());
            visitaEntity.setFechaModificacion(null);

            oUskiVisitasRepository.save(visitaEntity);
        }

        return oUskiVisitasRepository.count();
    }
}

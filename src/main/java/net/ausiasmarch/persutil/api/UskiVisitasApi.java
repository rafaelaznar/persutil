package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.persutil.entity.UskiVisitasEntity;
import net.ausiasmarch.persutil.service.UskiVisitasService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/visitas")
public class UskiVisitasApi {

    @Autowired
    UskiVisitasService oUskiVisitasService;

    // obtener registro por id
    @GetMapping("/{id}")
    public ResponseEntity<UskiVisitasEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oUskiVisitasService.get(id));
    }

    // crear registro
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody UskiVisitasEntity visitasEntity) {
        return ResponseEntity.ok(oUskiVisitasService.create(visitasEntity));
    }

    // modificar registro
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody UskiVisitasEntity visitasEntity) {
        return ResponseEntity.ok(oUskiVisitasService.update(visitasEntity));
    }

    // borrar registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oUskiVisitasService.delete(id));
    }

    // listado paginado de todos los registros para admin
    @GetMapping("/dashboard")
    public ResponseEntity<Page<UskiVisitasEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oUskiVisitasService.getPage(oPageable));
    }

    // listado paginado de registros publicados
    @GetMapping("")
    public ResponseEntity<Page<UskiVisitasEntity>> getPublished(Pageable oPageable) {
        return ResponseEntity.ok(oUskiVisitasService.getPublishedPage(oPageable));
    }

    // devolver cantidad de los registros
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oUskiVisitasService.count());
    }

    // rellenar datos fake visitas
    @GetMapping("/rellena/{numPosts}")
    public ResponseEntity<Long> rellenaBlog(@PathVariable Long numPosts) {
        return ResponseEntity.ok(oUskiVisitasService.rellenaBlog(numPosts));
    }
}

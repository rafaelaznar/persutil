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

import net.ausiasmarch.persutil.entity.AlcanyizEntity;
import net.ausiasmarch.persutil.service.AlcanyizService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/alcanyiz")
public class AlcanyizApi{

    @Autowired
    AlcanyizService oAlcanyizService;

    @GetMapping("/{id}")
    public ResponseEntity<AlcanyizEntity> get(@PathVariable Long id) {
        try {
            AlcanyizEntity e = oAlcanyizService.get(id);
            return ResponseEntity.ok(e);
        } catch (RuntimeException ex) {
           return ResponseEntity.notFound().build();
        }
    }

    // crear posts
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody AlcanyizEntity alcanyizEntity) {
        return ResponseEntity.ok(oAlcanyizService.create(alcanyizEntity));
    }

    // modificar posts
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody AlcanyizEntity alcanyizEntity) {
        return ResponseEntity.ok(oAlcanyizService.update(alcanyizEntity));
    }

    // borrar posts
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oAlcanyizService.delete(id));
    }

    // listado paginado de posts
    @GetMapping("")
    public ResponseEntity<Page<AlcanyizEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oAlcanyizService.getPage(oPageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oAlcanyizService.count()); 
    }

    @GetMapping("/rellena/{numPosts}")
    public ResponseEntity<Long> rellenaBlog(
            @PathVariable Long numPosts
    ) {
        return ResponseEntity.ok(oAlcanyizService.rellenaQuestions(numPosts));
    }
}
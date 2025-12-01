package net.ausiasmarch.persutil.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

import net.ausiasmarch.persutil.entity.CastanyeraEntity;
import net.ausiasmarch.persutil.service.AleatorioService;
import net.ausiasmarch.persutil.service.CastanyeraService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/castanyera")
public class CastanyeraApi {

    @Autowired
    AleatorioService oAleatorioService;

    @Autowired
    CastanyeraService oCastanyeraService;

    //---------------------------Rellenar datos fake blog---------------------------------

    @GetMapping("/rellena/{numPosts}")
    public ResponseEntity<Long> rellenaCastanyera(
            @PathVariable Long numPosts
    ) {
        return ResponseEntity.ok(oCastanyeraService.rellenaCastanyera(numPosts));
    }



    
    // ----------------------------CRUD---------------------------------

    // obtener post por id
    @GetMapping("/{id}")
    public ResponseEntity<CastanyeraEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oCastanyeraService.get(id));
    }

    // crear posts
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody CastanyeraEntity castanyeraEntity) {
        return ResponseEntity.ok(oCastanyeraService.create(castanyeraEntity));
    }

    // modificar posts
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody CastanyeraEntity castanyeraEntity) {
        return ResponseEntity.ok(oCastanyeraService.update(castanyeraEntity));
    }

    // borrar posts
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oCastanyeraService.delete(id));
    }

    // listado paginado de posts
    @GetMapping("")
    public ResponseEntity<Page<CastanyeraEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oCastanyeraService.getPage(oPageable));
        
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oCastanyeraService.count()); 
    }

}

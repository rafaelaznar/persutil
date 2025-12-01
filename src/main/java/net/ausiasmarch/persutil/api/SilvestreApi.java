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

import net.ausiasmarch.persutil.entity.SilvestreEntity;
import net.ausiasmarch.persutil.service.SilvestreService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/silvestre")
public class SilvestreApi {



    @Autowired
    SilvestreService oSilvestreService;

    // ------------------------ ENDPOINT TEST ------------------------

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return new ResponseEntity<>("\"Hola desde Silvestre\"", HttpStatus.OK);
    }

    // ------------------------ FAKE FILL ----------------------------

    @GetMapping("/rellena/{numItems}")
    public ResponseEntity<Long> rellenaSilvestre(@PathVariable Long numItems) {
        return ResponseEntity.ok(oSilvestreService.rellenaSilvestre(numItems));
    }

    // ---------------------------- CRUD -----------------------------

    // Obtener imagen por id
    @GetMapping("/{id}")
    public ResponseEntity<SilvestreEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(oSilvestreService.get(id));
    }

    // Crear imagen
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody SilvestreEntity oEntity) {
        return ResponseEntity.ok(oSilvestreService.create(oEntity));
    }

    // Modificar imagen
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody SilvestreEntity oEntity) {
        return ResponseEntity.ok(oSilvestreService.update(oEntity));
    }

    // Eliminar imagen
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(oSilvestreService.delete(id));
    }

    // Listado paginado de imágenes
    @GetMapping("")
    public ResponseEntity<Page<SilvestreEntity>> getPage(Pageable pageable) {
        return ResponseEntity.ok(oSilvestreService.getPage(pageable));
    }

    // Contador de registros
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(oSilvestreService.count());
    }
}

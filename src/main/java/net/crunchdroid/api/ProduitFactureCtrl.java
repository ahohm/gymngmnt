package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.ProduitFacture;
import net.crunchdroid.service.ProduitFactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produitfacture")
@AllArgsConstructor
public class ProduitFactureCtrl {

    private ProduitFactureService produitFactureService;

    @PostMapping("/add")
    public ResponseEntity<ProduitFacture> add(@RequestBody ProduitFacture produitFacture) {
        try {
            return new ResponseEntity(produitFactureService.save(produitFacture), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<ProduitFacture>> getAll() {
        try {
            return new ResponseEntity(produitFactureService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitFacture> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(produitFactureService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitFacture> update(@RequestBody ProduitFacture produitFacture) {
        try {
            return new ResponseEntity(produitFactureService.update(produitFacture), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(produitFactureService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

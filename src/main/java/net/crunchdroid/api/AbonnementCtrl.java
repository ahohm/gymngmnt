package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.Abonnement;
import net.crunchdroid.service.AbonnementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonnement")
@AllArgsConstructor
public class AbonnementCtrl {

    private AbonnementService abonnementService;

    @PostMapping("/add")
    public ResponseEntity<Abonnement> add(@RequestBody Abonnement abonnement) {
        try {
            return new ResponseEntity(abonnementService.save(abonnement), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Abonnement>> getAll() {
        try {
            return new ResponseEntity(abonnementService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(abonnementService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> update(@RequestBody Abonnement abonnement) {
        try {
            return new ResponseEntity(abonnementService.update(abonnement), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(abonnementService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

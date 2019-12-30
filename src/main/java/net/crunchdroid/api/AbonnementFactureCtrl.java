package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.AbonnementFacture;
import net.crunchdroid.service.AbonnementFactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonnementfacture")
@AllArgsConstructor
public class AbonnementFactureCtrl {

    private AbonnementFactureService abonnementFactureService;

    @PostMapping("/add")
    public ResponseEntity<AbonnementFacture> add(@RequestBody AbonnementFacture abonnement) {
        try {
            return new ResponseEntity(abonnementFactureService.save(abonnement), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<AbonnementFacture>> getAll() {
        try {
            return new ResponseEntity(abonnementFactureService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbonnementFacture> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(abonnementFactureService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbonnementFacture> update(@RequestBody AbonnementFacture abonnementFacture) {
        try {
            return new ResponseEntity(abonnementFactureService.update(abonnementFacture), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(abonnementFactureService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

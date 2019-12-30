package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.Entraineur;
import net.crunchdroid.service.EntraineurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entraineur")
@AllArgsConstructor
public class EntraineurCtrl {

    private EntraineurService entraineurService;

    @PostMapping("/add")
    public ResponseEntity<Entraineur> add(@RequestBody Entraineur entraineur) {
        try {
            return new ResponseEntity(entraineurService.save(entraineur), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Entraineur>> getAll() {
        try {
            return new ResponseEntity(entraineurService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entraineur> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(entraineurService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entraineur> update(@RequestBody Entraineur entraineur) {
        try {
            return new ResponseEntity(entraineurService.update(entraineur), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(entraineurService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

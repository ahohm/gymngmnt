package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.Abonne;
import net.crunchdroid.service.AbonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonne")
@AllArgsConstructor
public class AbonneCtrl {

    private AbonneService abonneService;

    @PostMapping("/add")
    public ResponseEntity<Abonne> add(@RequestBody Abonne abonne) {
        try {
            return new ResponseEntity(abonneService.save(abonne), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Abonne>> getAll() {
        try {
            return new ResponseEntity(abonneService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonne> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(abonneService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonne> update(@RequestBody Abonne abonne) {
        try {
            return new ResponseEntity(abonneService.update(abonne), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(abonneService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

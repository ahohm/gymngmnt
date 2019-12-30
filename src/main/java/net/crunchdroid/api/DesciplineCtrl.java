package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.Descipline;
import net.crunchdroid.service.DesciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descipline")
@AllArgsConstructor
public class DesciplineCtrl {

    private DesciplineService desciplineService;

    @PostMapping("/add")
    public ResponseEntity<Descipline> add(@RequestBody Descipline descipline) {
        try {
            return new ResponseEntity(desciplineService.save(descipline), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Descipline>> getAll() {
        try {
            return new ResponseEntity(desciplineService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descipline> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(desciplineService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Descipline> update(@RequestBody Descipline descipline) {
        try {
            return new ResponseEntity(desciplineService.update(descipline), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(desciplineService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

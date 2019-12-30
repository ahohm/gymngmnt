package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.Msg;
import net.crunchdroid.service.MsgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MsgCtrl {

    private MsgService msgService;

    @PostMapping("/add")
    public ResponseEntity<Msg> add(@RequestBody Msg msg) {
        try {
            return new ResponseEntity(msgService.save(msg), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Msg>> getAll() {
        try {
            return new ResponseEntity(msgService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Msg> getOne(@PathVariable long id) {
        try {
            return new ResponseEntity(msgService.getOneById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Msg> update(@RequestBody Msg msg) {
        try {
            return new ResponseEntity(msgService.update(msg), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        try {

            return new ResponseEntity(msgService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

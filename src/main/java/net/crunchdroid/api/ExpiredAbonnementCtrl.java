package net.crunchdroid.api;

import lombok.AllArgsConstructor;
import net.crunchdroid.model.ExpiredAbonnement;
import net.crunchdroid.service.ExpiredAbonnementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonactive")
@AllArgsConstructor
public class ExpiredAbonnementCtrl {

    private ExpiredAbonnementService expiredAbonnementService;

    @PostMapping("/add")
    public ResponseEntity<ExpiredAbonnement> add(@RequestBody ExpiredAbonnement expiredAbonnement) {
        try {
            return new ResponseEntity(expiredAbonnementService.save(expiredAbonnement), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<ExpiredAbonnement>> getAll() {
        try {
            return new ResponseEntity(expiredAbonnementService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

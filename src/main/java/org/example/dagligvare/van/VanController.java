package org.example.dagligvare.van;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vans")
public class VanController {

    private final VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

    @GetMapping
    public ResponseEntity<List<Van>> getAllVans() {
        try {
            return new ResponseEntity<>(vanService.getAllVans(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getVanById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(vanService.getVanById(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Van> postVan(@RequestBody Van request) {
        try {
            return new ResponseEntity<>(vanService.createVan(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity putVan(@PathVariable int id, @RequestBody Van request) {
        try {
            return new ResponseEntity<>(vanService.updateVan(id, request), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteVan(@PathVariable int id) {
        try {
            return vanService.deleteVan(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
package org.example.dagligvare.controllers;

import org.example.dagligvare.entities.Delivery;
import org.example.dagligvare.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        try {
            return new ResponseEntity<>(deliveryService.getAllDeliveries(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getDeliveryById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(deliveryService.getDeliveryById(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Delivery> postDelivery(@RequestBody Delivery request) {
        try {
            return new ResponseEntity<>(deliveryService.createDelivery(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity putDelivery(@PathVariable int id, @RequestBody Delivery request) {
        try {
            return new ResponseEntity<>(deliveryService.updateDelivery(id, request), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path= "/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable int id) {
        try {
            return deliveryService.deleteDelivery(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
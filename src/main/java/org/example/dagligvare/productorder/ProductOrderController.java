package org.example.dagligvare.productorder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productorders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOrder>> getAllProductOrders() {
        try {
            return new ResponseEntity<>(productOrderService.getAllProductOrders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getProductOrderById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(productOrderService.getProductOrderById(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProductOrder> postProductOrder(@RequestBody ProductOrder request) {
        try {
            return new ResponseEntity<>(productOrderService.createProductOrder(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity putProductOrder(@PathVariable int id, @RequestBody ProductOrder request) {
        try {
            return new ResponseEntity<>(productOrderService.updateProductOrder(id, request), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path= "/{id}")
    public ResponseEntity<String> deleteProductOrder(@PathVariable int id) {
        try {
            return productOrderService.deleteProductOrder(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

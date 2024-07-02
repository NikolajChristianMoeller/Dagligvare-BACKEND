package org.example.dagligvarebackend.productorder;


import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService {

    final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrder getProductOrderById(Integer id) {
        return productOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Product order with id " + id + " not found."));
    }

    public List<ProductOrder> getAllProductOrders() {
        try {
            return productOrderRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all product orders in service", e);
        }
    }

    public ProductOrder createProductOrder(ProductOrder newProductOrder) {
        try {
            return productOrderRepository.save(newProductOrder);
        } catch (Exception e) {
            throw new ServiceException("Error while creating product order in service", e);
        }
    }

    public ProductOrder updateProductOrder(int id, ProductOrder updatedProductOrder) {
        ProductOrder productOrderToUpdate = productOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Product order with id " + id + " not found."));
        if (updatedProductOrder.getId() == id) {
            productOrderToUpdate.setQuantity(updatedProductOrder.getQuantity());
            return productOrderRepository.save(productOrderToUpdate);
        } else {
            throw new RuntimeException("Error while updating product order in service.");
        }
    }

    public ResponseEntity<String> deleteProductOrder(int id){
        Optional<ProductOrder> productOrderToDelete = productOrderRepository.findById(id);
        if(productOrderToDelete.isPresent()) {
            productOrderRepository.deleteById(id);
            return ResponseEntity.ok().body("Product order with id " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Error while deleting product order in service:" + " " + "product order with id " + id + " not found.");
        }
    }
}

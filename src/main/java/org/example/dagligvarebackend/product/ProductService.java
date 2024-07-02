package org.example.dagligvarebackend.product;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found."));
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all products in service", e);
        }

    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new RuntimeException("Product with name " + name + " not found."));
    }

    public Product createProduct(Product newProduct) {
        try {
            return productRepository.save(newProduct);
        } catch (Exception e) {
            throw new ServiceException("Error while creating product in service", e);
        }
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product productToUpdate = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found."));
        if (updatedProduct.getId() == id) {
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setWeight(updatedProduct.getWeight());

            return productRepository.save(productToUpdate);
        } else {
            throw new RuntimeException("Error while updating product in service.");
        }
    }

    public ResponseEntity<String> deleteProduct(int id){
        Optional<Product> productToDelete = productRepository.findById(id);
        if(productToDelete.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().body("Product with id " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Error while deleting product in service:" + " " + "product with id " + id + " not found.");
        }
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        return productDTO;
    }
}

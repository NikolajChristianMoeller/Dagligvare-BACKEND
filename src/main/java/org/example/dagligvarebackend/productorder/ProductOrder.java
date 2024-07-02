package org.example.dagligvarebackend.productorder;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvarebackend.delivery.Delivery;
import org.example.dagligvarebackend.product.Product;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Delivery delivery;

}
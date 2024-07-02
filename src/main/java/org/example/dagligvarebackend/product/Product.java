package org.example.dagligvarebackend.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvarebackend.productorder.ProductOrder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double weight;

    @OneToMany
    private List<ProductOrder> productOrders;

}

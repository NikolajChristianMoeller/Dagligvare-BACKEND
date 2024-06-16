package org.example.dagligvare.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_orders")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Delivery delivery;

    public ProductOrder(int id, int quantity, Product product, Delivery delivery) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.delivery = delivery;
    }
}

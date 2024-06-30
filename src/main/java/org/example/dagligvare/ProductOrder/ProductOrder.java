package org.example.dagligvare.ProductOrder;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvare.Delivery.Delivery;
import org.example.dagligvare.Product.Product;

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

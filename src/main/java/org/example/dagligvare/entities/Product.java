package org.example.dagligvare.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double weight;

    public Product(int id, String name, double price, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}

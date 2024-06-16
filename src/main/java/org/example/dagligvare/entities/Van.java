package org.example.dagligvare.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vans")
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String brand;
    private String model;
    private int capacity;

    public Van(int id, String brand, String model, int capacity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
    }
}

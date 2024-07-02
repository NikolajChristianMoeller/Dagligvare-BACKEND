package org.example.dagligvarebackend.van;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvarebackend.delivery.Delivery;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int capacity;

    @OneToMany
    private List<Delivery> deliveries;

}
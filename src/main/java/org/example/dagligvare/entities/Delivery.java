package org.example.dagligvare.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    @ManyToOne
    private Van van;

    public Delivery(int id, LocalDate deliveryDate, String fromWarehouse, String destination, Van van) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
        this.van = van;
    }
}

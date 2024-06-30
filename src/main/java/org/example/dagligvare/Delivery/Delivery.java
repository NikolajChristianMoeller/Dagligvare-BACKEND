package org.example.dagligvare.Delivery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvare.Van.Van;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    @ManyToOne
    private Van van;

}

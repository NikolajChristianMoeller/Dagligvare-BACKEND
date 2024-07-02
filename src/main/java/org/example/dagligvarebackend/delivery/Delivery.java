package org.example.dagligvarebackend.delivery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dagligvarebackend.productorder.ProductOrder;
import org.example.dagligvarebackend.van.Van;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany
    private List<ProductOrder> productOrders;
}

package org.example.dagligvarebackend.delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDTO {
    private Long id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
}

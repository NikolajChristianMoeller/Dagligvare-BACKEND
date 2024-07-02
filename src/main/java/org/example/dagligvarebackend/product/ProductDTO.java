package org.example.dagligvarebackend.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private double weight;
}

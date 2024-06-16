package org.example.dagligvare.repositories;

import org.example.dagligvare.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}

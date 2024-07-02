package org.example.dagligvarebackend.productorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}

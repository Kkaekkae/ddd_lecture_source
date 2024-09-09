package com.sparta.ddd.infrastructure;

import com.sparta.ddd.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

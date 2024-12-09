package com.sparta.ddd.domain.repository;

import com.sparta.ddd.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: 레포지토리를 Interface 없이 바로 사용하는 예제
public interface ProductRepository extends JpaRepository<Product, Long> {
}

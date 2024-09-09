package com.sparta.ddd.application.service;

import com.sparta.ddd.application.dtos.product.ProductDto;
import com.sparta.ddd.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(ProductDto::of) // DTO 치환 로직을 static 메서드로 구현하면 코드가 간결해집니다.
                .orElseThrow();
    }
}

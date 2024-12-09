package com.sparta.ddd.application.service;

import com.sparta.ddd.application.dtos.product.ProductDto;
import com.sparta.ddd.domain.entity.product.Product;
import com.sparta.ddd.domain.entity.product.ProductDetail;
import com.sparta.ddd.domain.entity.product.ProductImage;
import com.sparta.ddd.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(ProductDto::of) // TODO: DTO 치환 로직 static 메서드 사용 예제
                .orElseThrow();
    }

    @Transactional
    public void updateImage(Long productId, String name, String url) {
        Product product = productRepository.findById(productId).orElseThrow();
        ProductDetail detail = product.getDetail();
        detail.updateImage(ProductImage.create(detail, name, url));
    }
}

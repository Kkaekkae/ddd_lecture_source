package com.sparta.ddd.application.service;

import com.sparta.ddd.domain.entity.product.Product;
import com.sparta.ddd.domain.entity.user.User;
import com.sparta.ddd.domain.repository.UserRepository;
import com.sparta.ddd.domain.service.UserProductDomainService;
import com.sparta.ddd.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private final UserProductDomainService userProductDomainService;

    public UserProductService(ProductRepository productRepository, UserRepository userRepository, UserProductDomainService userProductDomainService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userProductDomainService = userProductDomainService;
    }


    //TODO: 도메인 서비스 사용 예제
    @Transactional
    public void connectProductToUser(Long userId, Long productId) {
        final User user = userRepository.findById(userId).orElseThrow();
        final Product product = productRepository.findById(productId).orElseThrow();
        userProductDomainService.connectUserProduct(user, product);
    }

}

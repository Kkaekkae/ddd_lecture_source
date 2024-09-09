package com.sparta.ddd.domain.service;

import com.sparta.ddd.domain.entity.product.Product;
import com.sparta.ddd.domain.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserProductDomainService {

    /***
     * TODO: 도메인 서비스 구현 예제 (비즈니스 로직이 아닙니다! 도메인 로직을 구현해야 합니다)
     * User 엔티티에서 Product 엔티티를 불러올 수 없고,
     * Product 엔티티에서 User 엔티티를 불러올 수 없으니까 아래와 같은 도메인 서비스를 구현합니다.
     */
    public void connectUserProduct(User user, Product product) {
        user.changeToManufacture();
        product.updateManufacture(user.getName());
    }
}

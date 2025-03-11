package com.sparta.ddd.domain.service;

import com.sparta.ddd.domain.entity.product.Product;
import com.sparta.ddd.domain.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserProductDomainService {

    /***
     * TODO: 도메인 서비스 구현 예제 (도메인서비스에는 오직 도메인 로직만을 구현해야 합니다)
     * User 엔티티에서 Product 엔티티를 불러올 수 없고,
     * Product 엔티티에서 User 엔티티를 불러올 수 없으니까 아래와 같은 도메인 서비스를 구현하여 비즈니스의 규칙을 정의합니다.
     */
    public void connectUserProduct(User user, Product product) {
        user.changeToManufacture();
        product.updateManufacture(user.getName());
    }
}

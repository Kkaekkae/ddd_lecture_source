package com.sparta.ddd.domain.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "retail_price")
    private Long retailPrice;

    @Column(name = "supply_price")
    private Long supplyPrice;

    @OneToOne(mappedBy = "detail")
    private Product product;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.PERSIST)
    private List<ProductImage> images = new ArrayList<>();

    public static ProductDetail create(Product product, Long price) {
        ProductDetail productDetail = ProductDetail.builder()
                .product(product)
                .build();
        productDetail.updatePrice(price);
        return productDetail;
    }

    public void update(Long price) {
        updatePrice(price);
    }

    /***
     * TODO: DDD를 사용하면서 생기는 장점 (캡슐화)
     * ProductDetail 의 규칙을 가정함 - retailPrice 는 supplyPrice 의 1.2배로 한다.
     * 현재 ProductDetail 의 생성,수정 메서드에 규칙이 연결되어 있기 때문에
     * 추후 비즈니스 규칙이 변경되어 1.2 배의 기준이 변경될 때 ProductDetail 의 updatePrice 메서드만 수정하면 된다.
     */
    private void updatePrice(Long price) {
        this.retailPrice = Math.round(price * 1.2);
        this.supplyPrice = price;
    }


}

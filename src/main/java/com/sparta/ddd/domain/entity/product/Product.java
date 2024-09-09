package com.sparta.ddd.domain.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "product_id")
    private ProductDetail detail;

    // TODO: Entity 에 Value Object 연결 예시
    @Embedded
    private AuditingDate dateInfo;

    private String manufacturedBy;

    public static Product create(String name) {
        return Product.builder()
                .name(name)
                .build();
    }

    //TODO: 하위 Entity 의 depth 가 길고, 자주 사용하는 기능일 경우 .get().get().get() 형태를 줄이기 위한 함수도 제공할 수 있습니다.
    public List<ProductImage> getImages() {
        return this.detail.getImages();
    }

    public void updateManufacture(String username) {
        this.manufacturedBy = username;
    }

}

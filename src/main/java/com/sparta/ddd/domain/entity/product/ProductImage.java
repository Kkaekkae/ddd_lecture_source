package com.sparta.ddd.domain.entity.product;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_image")
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductDetail productDetail;

    public static ProductImage create(ProductDetail productDetail, String name, String url) {
        return ProductImage.builder()
                .name(name)
                .url(url)
                .build();
    }

    public void update(String name, String url) {
        this.name = name;
        this.url = url;
    }
}

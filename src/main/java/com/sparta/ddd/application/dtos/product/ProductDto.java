package com.sparta.ddd.application.dtos.product;

import com.sparta.ddd.domain.entity.product.Product;
import com.sparta.ddd.domain.entity.product.ProductImage;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class ProductDto {
    private Long productId;
    private String name;
    private Long retailPrice;
    private Long supplyPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ProductImageDto> images;

    //TODO: 연관 관계 Depth 가 깊은 Entity 치환 예제
    public static ProductDto of(Product product) {
        return ProductDto.builder()
                .productId(product.getId())
                .name(product.getName())
                .retailPrice(product.getDetail().getRetailPrice())
                .supplyPrice(product.getDetail().getSupplyPrice())
                .createdAt(product.getDateInfo().getCreatedAt())
                .updatedAt(product.getDateInfo().getUpdatedAt())
                // Option1. 내부 Entity 를 탐색하여 데이터 치환
                .images(product.getDetail().getImages().stream().map(ProductImageDto::of).collect(Collectors.toList()))
                // Option2. Root 에그리거트에 존재하는 함수를 이용한 데이터 치환
                // .images(product.getImages().stream().map(ProductImageDto::of).collect(Collectors.toList()))
                .build();
    }


    //TODO: DTO 치환 시 inner 클래스 구현 예제
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    public static class ProductImageDto {
        private String name;
        private String url;

        // TODO: Builder 패턴이 항상 만능은 아닙니다. 클래스 내에 변수가 몇개 없을 경우는 생성자로 대체가 가능합니다.
        public static ProductImageDto of(ProductImage image) {
            return new ProductImageDto(image.getName(), image.getUrl());
        }
    }
}

package com.example.store.dto.response;

import com.example.store.entity.Product;
import com.example.store.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseDto {

    public ProductResponseDto() {
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ProductRead{
        private Long id;

        // 사용자 아이디
        private Long user_id;
        // private Long user_id;

        private String title;
        private String contents;

        private int cost;
        private Category category;
    }

    public ResponseEntity<?> success(Product product) {

        ProductRead body=ProductRead.builder()
                .id(product.getId())
                .user_id(product.getUsers().getId())
                .title(product.getTitle())
                .contents(product.getContents())
                .cost(product.getCost())
                .category(product.getCategory())
                .build();
        return ResponseEntity.ok(body);
    }
}

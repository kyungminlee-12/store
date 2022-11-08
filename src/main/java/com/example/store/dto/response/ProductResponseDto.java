package com.example.store.dto.response;

import com.example.store.dao.CategoryDao;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProductResponseDto {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired   // 빈을 자동으로 mapping해주는 개념. 스스로 정의 안해도 사용 가능
    CategoryService categoryService;

    @Autowired
    CategoryDao categoryDao;

    public ProductResponseDto() {
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ProductRead{
        private Long id;

        // 사용자 아이디
        private Long user_id;
        private String title;
        private String contents;
        private int cost;

        // category 종류 호출하기
        // ArrayList<String> categoryList;
        ProductResponseDto.CategoryRes categoryList;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryRes{
        private boolean dictionary;
        private boolean fantasy;
        private boolean history;
        private boolean horror;
        private boolean humour;
        private boolean journal;
    }

    public ResponseEntity<?> success(Product product) {
        Long id= product.getCategory().getId();
        log.info("id: "+String.valueOf(id));

        ArrayList<String> categoryListDummy= new ArrayList<String>();
        categoryListDummy.add("Fantasy");
        categoryListDummy.add("History");

        ProductRead body=ProductRead.builder()
                .id(product.getId())
                .user_id(product.getUsers().getId())
                .title(product.getTitle())
                .contents(product.getContents())
                .cost(product.getCost())
                // .categoryList(categoryList)
                .categoryList(categoryDao.selectById(id))
                .build();
        return ResponseEntity.ok(body);
    }
}

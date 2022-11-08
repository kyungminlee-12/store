package com.example.store.service;

import com.example.store.dto.Response;
import com.example.store.dto.request.ProductRequestDto;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.entity.Users;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    @Autowired
    UsersService usersService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryTypeRepository;
    private final Response response;
    @Transactional
    public Product getProductInfo(Long id) {
        Product product=productRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("헤당 사용자는 없습니다");
        });
        return product;
    }

    public ResponseEntity<?> writeProduct(ProductRequestDto.Register product1) {

        List<Boolean> categories=product1.getCategories();

        Category categoryList = Category.builder()
                //.product(product1.getProduct().getId())
                .fantasy(categories.get(0))
                .horror(categories.get(1))
                .journal(categories.get(2))
                .history(categories.get(3))
                .humor(categories.get(4))
                .dictionary(categories.get(5))
                .build();
        categoryTypeRepository.save(categoryList);

        Product product= Product.builder()
                .users(usersService.getUsersInfo(product1.getUser_id()))
                .title(product1.getTitle())
                .contents((product1.getContents()))
                .cost(product1.getCost())
                .category((categoryList))
                .build();
        productRepository.save(product);

        return response.success("글 작성에 성공했습니다");
    }
}

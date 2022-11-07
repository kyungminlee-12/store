package com.example.store.service;

import com.example.store.dto.Response;
import com.example.store.dto.request.ProductRequestDto;
import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    @Autowired
    UsersService usersService;

    @Autowired
    ProductRepository productRepository;

    private final Response response;

    public ResponseEntity<?> writeProduct(ProductRequestDto.Register product1) {
        Product product= Product.builder()
                .users(usersService.getUsersInfo(product1.getUser_id()))
                .title(product1.getTitle())
                .contents((product1.getContents()))
                .cost(product1.getCost())
                .category((product1.getCategory()))
                .build();
        productRepository.save(product);

        return response.success("글 작성에 성공했습니다");
    }
}

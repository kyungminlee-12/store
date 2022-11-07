package com.example.store.controller;

import com.example.store.dto.Response;
import com.example.store.dto.request.ProductRequestDto;
import com.example.store.dto.response.ProductResponseDto;
import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;
import com.example.store.service.Helper;
import com.example.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductController {

    private final Response response;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ProductResponseDto productResponseDto;

    @PostMapping("/registeration")
    public ResponseEntity<?> writeGather(@Validated ProductRequestDto.Register write, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        // write.setWriteType(WriteType.Gather);
        // write.set_completed(true);

        return productService.writeProduct(write);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> readGather(@PathVariable("id") Long id) {

        // 참고 문헌: https://jogeum.net/9
        Optional<Product> optionalProduct=productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product1 = optionalProduct.get();
            log.info("gather test success");
            return productResponseDto.success(product1);
        }

        log.info("gather test fail");
        return null;
    }
}

package com.example.store.service;

import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Category getCategoryInfo(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("헤당 사용자는 없습니다");
        });
        return category;
    }

}

package com.example.store.repository;

import com.example.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

        Optional<Category> findById(Long id);

        // @Query("select u from Category cat where cat.id = ?1")
        // Category findByCategoryId(Long id);
}

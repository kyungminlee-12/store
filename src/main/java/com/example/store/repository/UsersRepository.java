package com.example.store.repository;


import com.example.store.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    // Optional<Users> findByUser_id(Long id);

    Optional<Users> findById(Long id);
    boolean existsByEmail(String email);
}

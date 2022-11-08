package com.example.store.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    @OneToOne(mappedBy = "category")
    private Product product;

    @Column(nullable = false)
    private boolean fantasy;

    @Column(nullable = false)
    private boolean horror;

    @Column(nullable = false)
    private boolean journal;

    @Column(nullable = false)
    private boolean history;

    @Column(nullable = false)
    private boolean humor;

    @Column(nullable = false)
    private boolean dictionary;

}

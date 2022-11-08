package com.example.store.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "product")
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @ManyToOne(targetEntity = Users.class)  // Many = Product, Users = One 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name="users")             // foreign key (userId) references User (id)
    private Users users;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @NotNull
    @Column(nullable = false)
    private int cost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}

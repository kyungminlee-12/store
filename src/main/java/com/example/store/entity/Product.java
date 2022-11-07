package com.example.store.entity;

import com.example.store.enums.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @ManyToOne(targetEntity = Users.class)  // Many = Product, Users = One 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name="user_id")             // foreign key (userId) references User (id)
    private Users users;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @NotNull
    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)    // enum의 이름으로 지정
    private Category category;
}

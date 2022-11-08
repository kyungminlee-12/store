package com.example.store.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductRequestDto {

    @Getter
    @Setter
    public static class Register {

        @NotNull(message = "user id는 필수 입력값입니다.")
        private Long user_id;

        @NotNull(message = "costs는 필수 입력값입니다.")
        private int cost;

        @NotNull(message = "title은 필수 입력값입니다.")
        private String title;

        @NotNull(message = "contents은 필수 입력값입니다.")
        private String contents;

        @NotNull(message = "categories는 필수 입력값입니다.")
        private List<Boolean> categories;

    }

}

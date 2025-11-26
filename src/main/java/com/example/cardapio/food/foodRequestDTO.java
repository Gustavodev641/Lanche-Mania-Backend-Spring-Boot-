package com.example.cardapio.food;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record foodRequestDTO(String title, String image, Integer price, Integer qtde, String description, String category) {



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class FoodRequestDTO {
        private String title;
        private Integer price;
        private String image;
        private Integer qtde;
        private String description;
        private String category;
    }
}

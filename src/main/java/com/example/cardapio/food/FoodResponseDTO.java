package com.example.cardapio.food;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class FoodResponseDTO {

    private Long id;
    private String title;
    private String image;
    private Integer price;
    private Integer qtde;
    private String description;
    private String category;


    public FoodResponseDTO(Long id, String title, String image, Integer price, Integer qtde, String description, String category) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;
        this.qtde = qtde;
        this.description = description;
        this.category = category;
    }




    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice(), food.getQtde(), food.getDescription(), food.getCategory());
    }


}

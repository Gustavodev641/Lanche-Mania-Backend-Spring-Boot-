package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Integer price;

    @Setter
    @Column(name = "qtde")
    private Integer qtde;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    public Food(@NotNull foodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
        this.qtde = data.qtde();
        this.description = data.description();
        this.category = data.category();

    }
    public void setTitle(String title) { this.title = title; }
    public void setImage(String image) { this.image = image; }
    public void setPrice(Integer price) { this.price = price; }
    public void setQtde(Integer qtde) { this.qtde = qtde; }
}
package com.example.cardapio.login;

import com.example.cardapio.customer.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CustomerLoginResponseDTO {
    private Long id;
    private String name;
    private String email;
    // Não inclua a senha aqui!

    public CustomerLoginResponseDTO(@NotNull Customers customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }
}
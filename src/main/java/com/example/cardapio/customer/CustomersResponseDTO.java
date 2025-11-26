package com.example.cardapio.customer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private String telefone;
    private String email;


    public CustomersResponseDTO(Customers customers) {
        this.id = customers.getId();
        this.name = customers.getName();
        this.cpf = customers.getCpf();
        this.telefone = customers.getTelefone();
        this.email = customers.getEmail();
    }
}
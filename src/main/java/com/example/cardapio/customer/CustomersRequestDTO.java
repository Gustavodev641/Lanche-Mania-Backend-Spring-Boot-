package com.example.cardapio.customer;



public record CustomersRequestDTO(
        String name,
        String cpf,
        String telefone,
        String email
) {}
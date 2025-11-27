package com.example.cardapio.customer;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Optional<Customers> findByEmail(String email);
    boolean existsByEmail(String email);
}

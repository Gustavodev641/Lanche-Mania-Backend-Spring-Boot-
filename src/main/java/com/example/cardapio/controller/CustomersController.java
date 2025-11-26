package com.example.cardapio.controller;

import com.example.cardapio.customer.*;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/food/Customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomersController {

    @Autowired
    private CustomersRepository repository;

    // POST - Agora devolve o cliente criado + status 201
    @PostMapping
    public ResponseEntity<CustomersResponseDTO> criarCliente(
            @RequestBody CustomersRequestDTO data,
            @NotNull UriComponentsBuilder uriBuilder) {

        Customers cliente = new Customers(data);
        repository.save(cliente);

        URI uri = uriBuilder.path("/food/Customers/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new CustomersResponseDTO(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping
    public ResponseEntity<List<CustomersResponseDTO>> listarTodos() {
        List<CustomersResponseDTO> lista = repository.findAll().stream()
                .map(CustomersResponseDTO::new)
                .toList();

        return ResponseEntity.ok(lista);
    }


}
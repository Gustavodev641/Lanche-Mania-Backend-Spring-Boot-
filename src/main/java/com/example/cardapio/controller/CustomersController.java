package com.example.cardapio.controller;

import com.example.cardapio.customer.*;
import com.example.cardapio.login.CustomerLoginResponseDTO;
import com.example.cardapio.login.LoginRequestDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/food/Customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomersController {

    @Autowired
    private CustomersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // CADASTRO - Criptografa a senha com BCrypt
    @PostMapping
    public ResponseEntity<?> criarCliente(
            @RequestBody CustomersRequestDTO data,
            @NotNull UriComponentsBuilder uriBuilder) {

        // Verificar se o email já existe
        if (repository.existsByEmail(data.email())) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Email já cadastrado");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        Customers cliente = new Customers(data);


        String senhaCriptografada = passwordEncoder.encode(data.password());
        cliente.setPassword(senhaCriptografada);

        repository.save(cliente);

        URI uri = uriBuilder.path("/food/Customers/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new CustomersResponseDTO(cliente));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO data) {
        Optional<Customers> customerOpt = repository.findByEmail(data.email());

        if (customerOpt.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Email ou senha incorretos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }

        Customers customer = customerOpt.get();


        if (!passwordEncoder.matches(data.password(), customer.getPassword())) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Email ou senha incorretos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }


        CustomerLoginResponseDTO response = new CustomerLoginResponseDTO(customer);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<CustomersResponseDTO>> listarTodos() {
        List<CustomersResponseDTO> lista = repository.findAll().stream()
                .map(CustomersResponseDTO::new)
                .toList();

        return ResponseEntity.ok(lista);
    }
}
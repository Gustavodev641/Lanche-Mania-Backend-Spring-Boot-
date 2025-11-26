    package com.example.cardapio.controller;


    import com.example.cardapio.food.*;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;

    @RestController
    @RequestMapping("food")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class FoodController {

        @Autowired
        private FoodRepository repository;

        @PostMapping
        public Food saveFood(@RequestBody foodRequestDTO data) {
            Food food = new Food(data);
            return repository.save(food);
        }

        @GetMapping
        public List<FoodResponseDTO> getAll() {
            return repository.findAll().stream()
                    .map(FoodResponseDTO::new)
                    .toList();
        }

        // + e − do estoque
        @PatchMapping("/{id}/estoque")
        public ResponseEntity<Object> atualizarEstoque(@PathVariable Long id,
                                                       @RequestBody Map<String, Integer> body) {
            return repository.findById(id)
                    .map(produto -> {
                        Integer qtde = body.get("qtde");
                        if (qtde != null && qtde >= 0) {
                            produto.setQtde(qtde);
                            repository.save(produto);
                        }
                        return ResponseEntity.ok().build();
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        // DELETE
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }
    }


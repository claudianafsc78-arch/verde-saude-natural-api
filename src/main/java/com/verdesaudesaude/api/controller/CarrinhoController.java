package com.verdesaudesaude.api.controller;

import com.verdesaudesaude.api.entity.Carrinho;
import com.verdesaudesaude.api.service.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhos")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> listarTodos() {
        return ResponseEntity.ok(carrinhoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Carrinho> salvar(@RequestBody Carrinho carrinho) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carrinhoService.salvar(carrinho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizar(
            @PathVariable Long id,
            @RequestBody Carrinho carrinho) {

        return ResponseEntity.ok(carrinhoService.atualizar(id, carrinho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        carrinhoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
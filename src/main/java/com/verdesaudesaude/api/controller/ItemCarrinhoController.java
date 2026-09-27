package com.verdesaudesaude.api.controller;

import com.verdesaudesaude.api.entity.ItemCarrinho;
import com.verdesaudesaude.api.service.ItemCarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-carrinho")
public class ItemCarrinhoController {

    private final ItemCarrinhoService itemCarrinhoService;

    public ItemCarrinhoController(ItemCarrinhoService itemCarrinhoService) {
        this.itemCarrinhoService = itemCarrinhoService;
    }

    @GetMapping
    public ResponseEntity<List<ItemCarrinho>> listarTodos() {
        return ResponseEntity.ok(itemCarrinhoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCarrinho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemCarrinhoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ItemCarrinho> salvar(@RequestBody ItemCarrinho itemCarrinho) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemCarrinhoService.salvar(itemCarrinho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCarrinho> atualizar(
            @PathVariable Long id,
            @RequestBody ItemCarrinho itemCarrinho) {

        return ResponseEntity.ok(itemCarrinhoService.atualizar(id, itemCarrinho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        itemCarrinhoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
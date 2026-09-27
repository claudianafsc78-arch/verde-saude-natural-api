package com.verdesaudesaude.api.controller;

import com.verdesaudesaude.api.entity.Produtor;
import com.verdesaudesaude.api.service.ProdutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtores")
public class ProdutorController {

    private final ProdutorService produtorService;

    public ProdutorController(ProdutorService produtorService) {
        this.produtorService = produtorService;
    }

    @GetMapping
    public ResponseEntity<List<Produtor>> listarTodos() {
        return ResponseEntity.ok(produtorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produtor> salvar(@RequestBody Produtor produtor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtorService.salvar(produtor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtor> atualizar(
            @PathVariable Long id,
            @RequestBody Produtor produtor) {

        return ResponseEntity.ok(produtorService.atualizar(id, produtor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
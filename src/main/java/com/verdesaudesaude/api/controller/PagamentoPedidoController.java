package com.verdesaudesaude.api.controller;

import com.verdesaudesaude.api.entity.Pagamento;
import com.verdesaudesaude.api.service.PagamentoPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PagamentoPedidoController {

    private final PagamentoPedidoService pagamentoPedidoService;

    public PagamentoPedidoController(PagamentoPedidoService pagamentoPedidoService) {
        this.pagamentoPedidoService = pagamentoPedidoService;
    }

    @PostMapping("/{pedidoId}/pagamento")
    public ResponseEntity<Pagamento> efetuarPagamento(
            @PathVariable Long pedidoId,
            @RequestParam String metodo) {

        return ResponseEntity.ok(
                pagamentoPedidoService.efetuarPagamento(pedidoId, metodo)
        );
    }
}
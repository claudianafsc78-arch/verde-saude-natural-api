package com.verdesaudesaude.api.service;

import com.verdesaudesaude.api.entity.Pagamento;
import com.verdesaudesaude.api.entity.Pedido;
import com.verdesaudesaude.api.repository.PagamentoRepository;
import com.verdesaudesaude.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoPedidoService {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoPedidoService(
            PagamentoRepository pagamentoRepository,
            PedidoRepository pedidoRepository) {

        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Pagamento efetuarPagamento(Long pedidoId, String metodo) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Pagamento pagamento = new Pagamento();
        pagamento.setMetodo(metodo);
        pagamento.setStatus("PAGO");
        pagamento.setPedido(pedido);

        pedido.setStatus("PAGO");
        pedidoRepository.save(pedido);

        return pagamentoRepository.save(pagamento);
    }
}
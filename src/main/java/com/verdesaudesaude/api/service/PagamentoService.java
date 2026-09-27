package com.verdesaudesaude.api.service;

import com.verdesaudesaude.api.entity.Pagamento;
import com.verdesaudesaude.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizar(Long id, Pagamento pagamento) {
        Pagamento pagamentoExistente = buscarPorId(id);

        pagamentoExistente.setMetodo(pagamento.getMetodo());
        pagamentoExistente.setStatus(pagamento.getStatus());
        pagamentoExistente.setPedido(pagamento.getPedido());

        return pagamentoRepository.save(pagamentoExistente);
    }

    public void excluir(Long id) {
        Pagamento pagamento = buscarPorId(id);
        pagamentoRepository.delete(pagamento);
    }
}
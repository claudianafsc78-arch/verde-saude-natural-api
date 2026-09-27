package com.verdesaudesaude.api.service;

import com.verdesaudesaude.api.entity.Carrinho;
import com.verdesaudesaude.api.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho atualizar(Long id, Carrinho carrinho) {
        Carrinho carrinhoExistente = buscarPorId(id);

        carrinhoExistente.setCliente(carrinho.getCliente());

        return carrinhoRepository.save(carrinhoExistente);
    }

    public void excluir(Long id) {
        Carrinho carrinho = buscarPorId(id);
        carrinhoRepository.delete(carrinho);
    }
}
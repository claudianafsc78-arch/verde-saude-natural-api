package com.verdesaudesaude.api.service;

import com.verdesaudesaude.api.entity.ItemCarrinho;
import com.verdesaudesaude.api.repository.ItemCarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoService {

    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinhoService(ItemCarrinhoRepository itemCarrinhoRepository) {
        this.itemCarrinhoRepository = itemCarrinhoRepository;
    }

    public List<ItemCarrinho> listarTodos() {
        return itemCarrinhoRepository.findAll();
    }

    public ItemCarrinho buscarPorId(Long id) {
        return itemCarrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do carrinho não encontrado"));
    }

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public ItemCarrinho atualizar(Long id, ItemCarrinho itemCarrinho) {
        ItemCarrinho itemExistente = buscarPorId(id);

        itemExistente.setQuantidade(itemCarrinho.getQuantidade());
        itemExistente.setCarrinho(itemCarrinho.getCarrinho());
        itemExistente.setProduto(itemCarrinho.getProduto());

        return itemCarrinhoRepository.save(itemExistente);
    }

    public void excluir(Long id) {
        ItemCarrinho itemCarrinho = buscarPorId(id);
        itemCarrinhoRepository.delete(itemCarrinho);
    }
}
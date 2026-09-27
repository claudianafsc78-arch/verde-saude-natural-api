package com.verdesaudesaude.api.service;

import com.verdesaudesaude.api.entity.Produtor;
import com.verdesaudesaude.api.repository.ProdutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public ProdutorService(ProdutorRepository produtorRepository) {
        this.produtorRepository = produtorRepository;
    }

    public List<Produtor> listarTodos() {
        return produtorRepository.findAll();
    }

    public Produtor buscarPorId(Long id) {
        return produtorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produtor não encontrado"));
    }

    public Produtor salvar(Produtor produtor) {
        return produtorRepository.save(produtor);
    }

    public Produtor atualizar(Long id, Produtor produtor) {
        Produtor produtorExistente = buscarPorId(id);

        produtorExistente.setNome(produtor.getNome());
        produtorExistente.setTelefone(produtor.getTelefone());
        produtorExistente.setEndereco(produtor.getEndereco());

        return produtorRepository.save(produtorExistente);
    }

    public void excluir(Long id) {
        Produtor produtor = buscarPorId(id);
        produtorRepository.delete(produtor);
    }
}
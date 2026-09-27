package com.verdesaudesaude.api.repository;

import com.verdesaudesaude.api.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
package com.verdesaudesaude.api.repository;

import com.verdesaudesaude.api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
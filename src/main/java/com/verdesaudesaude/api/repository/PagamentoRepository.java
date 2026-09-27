package com.verdesaudesaude.api.repository;

import com.verdesaudesaude.api.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
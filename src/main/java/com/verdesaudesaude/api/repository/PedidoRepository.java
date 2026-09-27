package com.verdesaudesaude.api.repository;

import com.verdesaudesaude.api.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
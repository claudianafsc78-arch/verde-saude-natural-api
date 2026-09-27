package com.verdesaudesaude.api.repository;

import com.verdesaudesaude.api.entity.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
}
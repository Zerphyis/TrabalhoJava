package com.example.javajuca.model;

import com.example.javajuca.table.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProdutos extends JpaRepository<Produtos, Long> {
}

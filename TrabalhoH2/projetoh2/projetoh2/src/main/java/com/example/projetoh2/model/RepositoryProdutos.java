package com.example.projetoh2.model;

import com.example.projetoh2.table.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProdutos extends JpaRepository<Produtos , Long> {

}

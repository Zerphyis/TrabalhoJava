package com.example.javajuca.model;

import com.example.javajuca.table.Produtos;
import com.example.javajuca.table.TiposProdutos;

public record ProdutosDto (Long id, String nome, TiposProdutos tipo, Double valor, Integer quantidade){
    public ProdutosDto(Produtos produto) {
        this(produto.getId(), produto.getNome(), produto.getTipo(), produto.getValor(), produto.getQuantidade());
    }
}

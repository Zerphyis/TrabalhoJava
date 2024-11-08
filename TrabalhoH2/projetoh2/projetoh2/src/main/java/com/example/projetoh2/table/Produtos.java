package com.example.projetoh2.table;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of="id")
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo não pode ser nulo.")
    private TipoProdutos tipo;

    @NotNull(message = "O valor não pode ser nulo.")
    private  Double valor;

    @NotNull(message = "A quantidade não pode ser nula.")

    private Integer  quantidade;

    public Produtos(String nome, TipoProdutos tipo, Double valor, Integer quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProdutos getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutos tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

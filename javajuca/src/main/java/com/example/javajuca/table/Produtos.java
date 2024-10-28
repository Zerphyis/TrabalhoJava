package com.example.javajuca.table;

import com.example.javajuca.model.ProdutosDto;
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
    private TiposProdutos tipo;

    @NotNull(message = "O valor não pode ser nulo.")
    private  Double valor;

    @NotNull(message = "A quantidade não pode ser nula.")

    private Integer  quantidade;

    public Produtos(Long id, String nome, TiposProdutos tipo, Double valor, Integer quantidade) {
        this.id = id;
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

    public TiposProdutos getTipo() {
        return tipo;
    }

    public void setTipo(TiposProdutos tipo) {
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

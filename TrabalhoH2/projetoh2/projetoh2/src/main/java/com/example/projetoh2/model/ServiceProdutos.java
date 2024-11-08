package com.example.projetoh2.model;

import com.example.projetoh2.table.Produtos;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProdutos {
    @Autowired
    RepositoryProdutos repositoryProduto;

    @Transactional
    public void adicionarProduto(Produtos produtoDto) {
        if (produtoDto.getNome() == null || produtoDto.getTipo() == null ||
                produtoDto.getValor() == null || produtoDto.getQuantidade() == null) {
            throw new IllegalArgumentException("Todos os campos do produto devem ser preenchidos.");
        }


        repositoryProduto.save(produtoDto);
    }

    public List<Produtos> buscarProdutos() {

        return repositoryProduto.findAll();
    }


    @Transactional
    public void atualizarProduto(Long id, Produtos produtoDto) {
        Optional<Produtos> produtoOptional = repositoryProduto.findById(id);
        if (produtoOptional.isPresent()) {
            Produtos produto = produtoOptional.get();


            if (produtoDto.getNome() == null || produtoDto.getTipo() == null ||
                    produtoDto.getValor() == null || produtoDto.getQuantidade() == null) {
                throw new IllegalArgumentException("Um ou mais campos do produto não podem ser nulos.");
            }

            produto.setNome(produtoDto.getNome());
            produto.setTipo(produtoDto.getTipo());
            produto.setValor(produtoDto.getValor());
            produto.setQuantidade(produtoDto.getQuantidade());

            repositoryProduto.save(produto);
        } else {
            throw new EntityNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }


    @Transactional

    public void excluirProduto(Long id) {
        if (repositoryProduto.existsById(id)) {
            repositoryProduto.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }

}

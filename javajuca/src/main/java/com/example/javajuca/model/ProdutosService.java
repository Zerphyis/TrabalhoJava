package com.example.javajuca.model;

import com.example.javajuca.table.Produtos;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutosService {
    @Autowired
    RepositoryProdutos repositoryProduto;

    @Transactional
    public void adicionarProdutos(List<ProdutosDto> produtos) {
        for (ProdutosDto produtoDto : produtos) {
            Produtos produto = new Produtos(
                    produtoDto.id(),
                    produtoDto.nome(),
                    produtoDto.tipo(),
                    produtoDto.valor(),
                    produtoDto.quantidade()
            );
            repositoryProduto.save(produto);
        }
    }
    public List<Produtos> buscarProdutos() {
        return repositoryProduto.findAll();
    }

    @Transactional
    public void atualizarProduto(Long id, ProdutosDto produtoDto) {
        Optional<Produtos> produtoOptional = repositoryProduto.findById(id);
        if (produtoOptional.isPresent()) {
            Produtos produto = produtoOptional.get();

            // Verificação dos campos
            if (produtoDto.nome() == null || produtoDto.tipo() == null ||
                    produtoDto.valor() == null || produtoDto.quantidade() == null) {
                throw new IllegalArgumentException("Um ou mais campos do produto não podem ser nulos.");
            }

            produto.setNome(produtoDto.nome());
            produto.setTipo(produtoDto.tipo());
            produto.setValor(produtoDto.valor());
            produto.setQuantidade(produtoDto.quantidade());

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

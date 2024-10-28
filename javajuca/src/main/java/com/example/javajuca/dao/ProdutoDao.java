package com.example.javajuca.dao;

import com.example.javajuca.model.ProdutosDto;
import com.example.javajuca.model.ProdutosService;
import com.example.javajuca.table.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ProdutoDao {
    @Autowired
    ProdutosService repositorio;

    @PostMapping//C
    public ResponseEntity<Produtos> criandoProdutos(@RequestBody List<ProdutosDto> dados) {
        repositorio.adicionarProdutos(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping//R
    public ResponseEntity<List<Produtos>> buscarProdutos() {
        List<Produtos> produtos = repositorio.buscarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("atualizar/{id}") // U
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosDto produtoDto) {
        repositorio.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok("Produto com ID " + id + " atualizado com sucesso.");
    }

    @DeleteMapping("/{id}") // D
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        repositorio.excluirProduto(id);
        return ResponseEntity.ok("Produto com ID " + id + " excluído com sucesso.");
    }
}

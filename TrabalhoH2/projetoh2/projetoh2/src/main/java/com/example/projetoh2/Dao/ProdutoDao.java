package com.example.projetoh2.Dao;

import com.example.projetoh2.model.ServiceProdutos;
import com.example.projetoh2.table.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class ProdutoDao {
    @Autowired
    private ServiceProdutos produtosService;

    @GetMapping("/listar")
    public ModelAndView listarProdutos() {
        List<Produtos> produtos = produtosService.buscarProdutos();
        ModelAndView model =new ModelAndView("GestaoEstoque");
        model.addObject("produtos", produtos);
        return model;
    }

    @PostMapping("/criar")
    public String adicionarProduto(@ModelAttribute Produtos produto) {
        produtosService.adicionarProduto(produto);
        return "redirect:/estoque/listar";
    }
    @PostMapping ("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute Produtos produtoAtualizado) {
        produtosService.atualizarProduto(id, produtoAtualizado);
        return "redirect:/estoque/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtosService.excluirProduto(id);
        return "redirect:/estoque/listar";
    }
}

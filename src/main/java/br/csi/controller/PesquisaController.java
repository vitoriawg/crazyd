package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/pesquisa")
public class PesquisaController {

    @PostMapping("/produto")
    public String pesquisa(@RequestParam String pesquisa, Model model ){
        System.out.println(pesquisa);
        ArrayList<Produto> produto = new ProdutoDao().getPesquisa(pesquisa);

        model.addAttribute("produtos", produto);

        return "visualizarproduto";


    }

    @PostMapping("/produtoCrud")
    public String pesquisaCrud(@RequestParam String pesquisa, @ModelAttribute("produto") Produto produto, Model model ){
        System.out.println(pesquisa);
        ArrayList<Produto> produtos = new ProdutoDao().getPesquisa(pesquisa);
        model.addAttribute("produtos", produtos);
        System.out.println(produto.getNome());
        return "produtos";


    }
}

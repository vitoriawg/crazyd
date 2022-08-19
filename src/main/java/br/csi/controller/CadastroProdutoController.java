package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {

    ProdutoDao pdao = new ProdutoDao();

    @GetMapping("/listar")
    public String addProduto(@ModelAttribute("produto") Produto produto, Model model) {
        model.addAttribute("produtos", pdao.getProdutosADM());

        return "produtos";
    }
    
    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("produto") Produto produto, RedirectAttributes redirect) {
        if (pdao.Cadastrar(produto)) {
            redirect.addFlashAttribute("retorno", "Cadastro feito com sucesso");
        } else {
            redirect.addFlashAttribute("retorno", "Erro no cadastro");
        }

        return new RedirectView("/produto/listar", true);
    }
}

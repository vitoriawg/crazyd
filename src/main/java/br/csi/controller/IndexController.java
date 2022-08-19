package br.csi.controller;

import br.csi.dao.ProdutoDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    ProdutoDao pDao = new ProdutoDao();

    @GetMapping("/")
    public RedirectView indexController() {
        return new RedirectView("/home", true);
    }

    @GetMapping("/home")
    public String produtos(Model model) {
        model.addAttribute("produtos", pDao.getProdutos());

        return "visualizarproduto";
    }

    @GetMapping("/produtos")
    public String cadastrar_produtos(Model model) {
        model.addAttribute("produtos", pDao.getProdutos());

        return "produtos";
    }





}

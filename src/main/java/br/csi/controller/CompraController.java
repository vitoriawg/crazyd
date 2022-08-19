package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Compra;
import br.csi.model.Produto;
import br.csi.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/compra")
public class CompraController {
    ProdutoDao produto = new ProdutoDao();
    @GetMapping("/produto")
    public String comprar(@RequestParam int id_produto, int id_usuario,  Model model) {

        System.out.println(id_produto);
        System.out.println(id_usuario);
        boolean compra = new ProdutoDao().Comprar(id_usuario, id_produto);


        model.addAttribute("id_usuario", id_usuario);

        return "redirect:compras?id_usuario="+id_usuario;
    }

    @GetMapping("/compras")
    public Object exibirCompra(@RequestParam("id_usuario") int id,  Model model) {
            model.addAttribute("produtos", produto.getCompra(id));


            return "compras";


    }

    @GetMapping("/vendas")
    public Object exibirVendas(Model model) {
        model.addAttribute("produtos", produto.getVenda());
        return "vendas";


    }
}



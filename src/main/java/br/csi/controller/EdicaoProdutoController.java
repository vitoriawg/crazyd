package br.csi.controller;


import br.csi.dao.ProdutoDao;
import br.csi.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/produto")
public class EdicaoProdutoController {
    @GetMapping("/editar")
    public String editar( @RequestParam int id, Model model ){

        Produto produto = new ProdutoDao().getProduto1(id);
        System.out.println(produto.getId());
        model.addAttribute("produto", produto);
        return "editar";
    }
    @PostMapping("editar")
    public Object editar_produto(@ModelAttribute("produto") Produto produto, RedirectAttributes attributes) {

        if(new ProdutoDao().Editar(produto)) {
            System.out.println("editou");
            attributes.addFlashAttribute("retorno","Edição feita com sucesso");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;
        }else {
            System.out.println("Não editou");
            attributes.addFlashAttribute("retorno","Ouve uma Falha ao editar");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;
        }
    }
    @GetMapping("/desativar")
    public Object desativar(@RequestParam int id, Model model, RedirectAttributes attributes ){

        Produto produto = new ProdutoDao().getProduto1(id);

        if(new ProdutoDao().Desativar(produto)) {
            System.out.println("desativou");
            attributes.addFlashAttribute("retorno","Anúncio desativado com sucesso");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;

        }else {

            System.out.println("deu ruim");

            attributes.addFlashAttribute("erro","Erro ao desativar anúncio :´(");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;
        }

    }

    @GetMapping("/ativar")
    public Object ativar(@RequestParam int id, Model model, RedirectAttributes attributes ){

        Produto produto = new ProdutoDao().getProduto1(id);

        if(new ProdutoDao().Ativar(produto)) {
            System.out.println("ativou");
            attributes.addFlashAttribute("retorno","Anúncio ativado com sucesso");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;

        }else {

            System.out.println("não ativou");

            attributes.addFlashAttribute("erro","Erro ao ativar anúncio :´(");
            RedirectView redirect = new RedirectView("/produto/listar", true);
            return redirect;
        }

    }
    @PostMapping("/deletar")
    public RedirectView deletar(@RequestParam int id, Model model, ProdutoDao produtoDao) {

            produtoDao.deletar(produtoDao.getProduto1(id));

        return new RedirectView("/produtos/listar", true);
    }





}

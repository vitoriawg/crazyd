package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "login";
    }



    @PostMapping("/autenticar")
    public RedirectView autenticar(@RequestParam String email, @RequestParam  String senha, HttpServletRequest req, Model model, RedirectAttributes redirect){
        Usuario usuario = new UsuarioService().autenticado(email, senha);

        System.out.println( email + senha);
        req.getSession();
        HttpSession sessao = req.getSession();
        sessao.setAttribute("usuario_logado", usuario);


        if(usuario != null){
            ProdutoDao pDao = new ProdutoDao();
            model.addAttribute("produtos", pDao.getProdutos());
//            System.out.println("usuario logado "+ usuario.getPermissao());
            return new RedirectView("/home", true);

        }else {
            redirect.addFlashAttribute("erro", "Email ou senha incorreto");
            return new RedirectView("/login", true);

        }

    }
    @GetMapping("/sair")
    public RedirectView sair(HttpSession session){
        session.invalidate();
        return new RedirectView("/home", true);
    }

}

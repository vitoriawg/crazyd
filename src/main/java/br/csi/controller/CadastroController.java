package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.dao.UsuarioDao;
import br.csi.model.Produto;
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
@RequestMapping("/cadastro")
public class CadastroController {

    UsuarioDao udao = new UsuarioDao();

    @GetMapping("/redirect")
    public String redirect() {

        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirect) {


        if (new UsuarioService().CadastrarUsuario(usuario)) {
            redirect.addFlashAttribute("retorno", "Cadastro feito com sucesso");
            return new RedirectView("/login", true);

        } else {
            redirect.addFlashAttribute("erro", "Erro no cadastro");
            return new RedirectView("/cadastro/redirect", true);
        }


    }
    @GetMapping("/visualizar")
    public String visualizar(@RequestParam String email, Model model ){

      Usuario usuario = new UsuarioDao().getUsuario(email);

        model.addAttribute("usuario", usuario);

        return "conta-visualizar";

    }

    @PostMapping("/editar")
    public String editar(@RequestParam String email, Model model  ){

        Usuario usuario = new UsuarioDao().getUsuario(email);
        System.out.println();
        model.addAttribute("usuario", usuario);


        return "editar-cadastro";

    }


    @PostMapping("edicao")
    public Object editar_cadastro(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attributes, HttpServletRequest req) {


        if(new UsuarioDao().Editar(usuario)) {
            System.out.println("cadastrou");
            attributes.addFlashAttribute("retorno","Edição feita com sucesso");
            req.getSession();
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario_logado", usuario);
            System.out.println(usuario.getNome());
            return "redirect:visualizar?email="+usuario.getEmail();
        }else {

            System.out.println("deu ruim");

            attributes.addFlashAttribute("erro","Ocorreu um erro ao editar");
            RedirectView redirect = new RedirectView("/cadastro/visualizar", true);
            return redirect;



        }

    }
}

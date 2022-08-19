package br.csi.service;

import br.csi.dao.UsuarioDao;
import br.csi.model.Usuario;

public class UsuarioService {

   // private UsuarioDao dao;

    public  Usuario autenticado (String email, String senha){

                    Usuario usuario = new UsuarioDao().getUsuario(email);

        try {
            if(usuario.getEmail().equals(email)&&usuario.getSenha().equals(senha) && usuario.isAtivo()){
                System.out.println(usuario.isAtivo());
                return usuario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean CadastrarUsuario(Usuario u){

        String retorno = new UsuarioDao().Cadastrar(u);

        if(retorno.equals("ok")){

            return true;

        }else {
            return false;
        }
    }


}

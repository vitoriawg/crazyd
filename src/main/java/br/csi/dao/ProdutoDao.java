package br.csi.dao;

import br.csi.model.Compra;
import br.csi.model.Produto;

import java.sql.*;
import java.util.ArrayList;


public class ProdutoDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String status;


    public ArrayList<Produto> getProdutos(){

        ArrayList<Produto> produtos = new ArrayList<>();
        try (Connection connection = new ConectaDB().getConexao()) {


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from produtos where ativo is true and quantidade > 0");


            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("nomeprod"));
                produto.setPreco(resultSet.getFloat("preco"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setId((resultSet.getInt("id_produto")));
                produto.setDescricao(resultSet.getString("descricao"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    public boolean deletar(Produto p) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "DELETE FROM produtos WHERE id_produto=?";
            PreparedStatement ptsm = con.prepareStatement(sql);
            ptsm.setInt(1, p.getId());
            ptsm.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<Produto> getProdutosADM(){

        ArrayList<Produto> produtos = new ArrayList<>();
        try (Connection connection = new ConectaDB().getConexao()) {


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from produtos ");


            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("nomeprod"));
                produto.setPreco(resultSet.getFloat("preco"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setId((resultSet.getInt("id_produto")));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setAtivo(resultSet.getBoolean("ativo"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return produtos;
    }


    public Produto getProduto1(int id){

        Produto produto = new Produto();
        try (Connection connection = new ConectaDB().getConexao()) {



            this.sql = "select * from produtos where id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);

            this.resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()){

                produto.setNome(resultSet.getString("nomeprod"));
                produto.setPreco(resultSet.getFloat("preco"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setId((resultSet.getInt("id_produto")));
                produto.setDescricao((resultSet.getString("descricao")));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public ArrayList<Produto> getPesquisa(String pesquisa){

        ArrayList<Produto> produtos = new ArrayList<>();
        try (Connection connection = new ConectaDB().getConexao()) {



            this.sql = "SELECT * FROM produtos WHERE nomeprod ILIKE ? ";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, '%'+pesquisa+'%');

            this.resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("nomeprod"));
                produto.setPreco(resultSet.getFloat("preco"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setId((resultSet.getInt("id_produto")));
                produto.setDescricao((resultSet.getString("descricao")));
                produtos.add(produto);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return produtos;
    }


    public boolean Cadastrar(Produto produto) {



        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "INSERT INTO produtos (nomeprod, preco, quantidade, descricao, ativo )"+
                    "  values (?, ?, ?,?, true)";

            this.preparedStatement = connection.prepareStatement(this.sql, preparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, produto.getNome());
            this.preparedStatement.setFloat(2, produto.getPreco());
            this.preparedStatement.setInt(3, produto.getQuantidade());
            this.preparedStatement.setString(4, produto.getDescricao());


            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();
            if(this.resultSet.getInt(1) > 0){

                produto.setId(this.resultSet.getInt(1));
                this.status = "ok";
            }

            if(this.status. equals("ok")){
                this.sql = "insert into permissao(id_usuario, id_permissao) values (?, ?); ";
                this.preparedStatement = connection.prepareStatement(this.sql);
                this.preparedStatement.setInt(1, produto.getId());
                this.preparedStatement.setInt(2,2);
                this.status = "ok";
                return true;
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }

    public boolean Editar (Produto produto) {



        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "update produtos set nomeprod = ? , preco = ? , quantidade = ?, descricao = ? where id_produto = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, produto.getNome());
            this.preparedStatement.setFloat(2, produto.getPreco());
            this.preparedStatement.setInt(3, produto.getQuantidade());
            this.preparedStatement.setString(4, produto.getDescricao());
            this.preparedStatement.setInt(5, produto.getId());


            this.preparedStatement.executeUpdate();


            if(this.preparedStatement.getUpdateCount() > 0){

                this.status = "ok";
                return true;
            }


        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }

    public boolean Desativar(Produto produto) {

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "update produtos set ativo = false where id_produto = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setInt(1, produto.getId());


            this.preparedStatement.execute();


            if(this.preparedStatement.getUpdateCount() > 0){

                this.status = "ok";
                return true;
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }


    public boolean Ativar(Produto produto) {

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "update produtos set ativo = true where id_produto = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setInt(1, produto.getId());


            this.preparedStatement.execute();


            if(this.preparedStatement.getUpdateCount() > 0){

                this.status = "ok";
                return true;
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }

    public boolean Comprar(int id_usuario,int id_produto) {



        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "begin; INSERT INTO compra ( id_usuario, id_produto, data_compra )"+
                    "  values (?, ?,current_date);" +
                    "update produtos set quantidade = quantidade -1 where id_produto = ?;" +
                    "commit;";

            this.preparedStatement = connection.prepareStatement(this.sql, preparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, id_usuario);
            this.preparedStatement.setInt(2, id_produto);
            this.preparedStatement.setInt(3, id_produto);



            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();
            if(this.resultSet.getInt(1) > 0){

               Compra.setid_compra(this.resultSet.getInt(1));
                this.status = "ok";
            }


        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }

    public ArrayList<Compra> getCompra(int id){

        ArrayList<Compra> compras = new ArrayList<>();
        try (Connection connection = new ConectaDB().getConexao()) {

            this.sql = "select produtos.id_produto,produtos.nomeprod, produtos.preco, produtos.quantidade, produtos.descricao,compra.data_compra, usuario.nome from produtos, compra, usuario \n" +
                    "where produtos.id_produto = compra.id_produto \n" +
                    "and compra.id_usuario = usuario.id_usuario \n" +
                    "and usuario.id_usuario=?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);

            this.resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()){
                Compra compra = new Compra();
                compra.setNome(resultSet.getString("nomeprod"));
                compra.setPreco(resultSet.getFloat("preco"));
                compra.setQuantidade(resultSet.getInt("quantidade"));
                compra.setId((resultSet.getInt("id_produto")));
                compra.setDescricao((resultSet.getString("descricao")));
                compra.setData_compra(resultSet.getDate("data_compra"));
                compra.setNome_comprador(resultSet.getString("nome"));
                compras.add(compra);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return compras;
    }

    public ArrayList<Compra> getVenda(){

        ArrayList<Compra> compras = new ArrayList<>();
        try (Connection connection = new ConectaDB().getConexao()) {

            this.sql = "select produtos.id_produto,produtos.nomeprod, produtos.preco, produtos.quantidade, produtos.descricao,compra.data_compra, usuario.nome from produtos, compra, usuario \n" +
                    "where produtos.id_produto = compra.id_produto \n" +
                    "and compra.id_usuario = usuario.id_usuario" ;
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()){
                Compra compra = new Compra();
                compra.setNome(resultSet.getString("nomeprod"));
                compra.setPreco(resultSet.getFloat("preco"));
                compra.setQuantidade(resultSet.getInt("quantidade"));
                compra.setId((resultSet.getInt("id_produto")));
                compra.setDescricao((resultSet.getString("descricao")));
                compra.setData_compra(resultSet.getDate("data_compra"));
                compra.setNome_comprador(resultSet.getString("nome"));

                compras.add(compra);

            }





        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return compras;
    }



}


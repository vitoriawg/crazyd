package br.csi.dao;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

    private static final String DRIVER  = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/crazyd";
    private static final String USER = "postgres";
    private static final String SENHA = "12345";

    public  static  void main(String args[]) throws ClassNotFoundException {
        new ConectaDB().getConexao();
    }

    public Connection getConexao() throws ClassNotFoundException {

        Connection con = null;


        try{
            Class.forName(this.DRIVER);
            con = DriverManager.getConnection(this.URL, this.USER, this.SENHA);

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();




        }


        return con;

    }


}

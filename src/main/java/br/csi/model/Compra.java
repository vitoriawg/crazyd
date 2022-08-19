package br.csi.model;

import java.util.Date;


public class Compra extends Produto  {

    private static int id_compra;

    private Date data_compra;

    private String nome_comprador;

    public Compra() {

    }

    public int getId_compra() {
        return id_compra;
    }

    public static void setid_compra(int id) {
        id_compra = id;
    }


    public static void setId_compra(int id_compra) {
        Compra.id_compra = id_compra;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public String getNome_comprador() {
        return nome_comprador;
    }

    public void setNome_comprador(String nome_comprador) {
        this.nome_comprador = nome_comprador;
    }
}

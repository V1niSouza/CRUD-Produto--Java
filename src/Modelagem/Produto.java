/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

/**
 *
 * @author vsouza
 */
public class Produto {
    private int codigo;
    private String nomeProduto;
    private String descricao;

    
    Conexao conProd = new Conexao();
    public Produto() {
        this(0, "", "");
    }

    public Produto(int codigo, String nomeProduto, String descricao) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void cadastrarProduto(){
        String sql;
        sql = "Insert into produto(codigo, nome_prod, descr) values"+
                    "('" + getCodigo() + "','" + getNomeProduto() + "','" + getDescricao() + "')";
        conProd.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registrado com sucesso");
    }
    
     public ResultSet listarProduto(){
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from produto";
        tabela = conProd.RetornarResultset(sql);
     return tabela;   
    }
     
     public void excluir(){
        String sql;
        sql= "Delete from produto where codigo="+ getCodigo();
        conProd.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso...");
    }
    
     public void alterar(){
        String sql;
        sql="Update produto set codigo='"+ getCodigo()+"', nome_prod='"+ getNomeProduto()+"', descr='"+getDescricao()+"' where codigo="+ getCodigo();
        conProd.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso...");
        
    }
}

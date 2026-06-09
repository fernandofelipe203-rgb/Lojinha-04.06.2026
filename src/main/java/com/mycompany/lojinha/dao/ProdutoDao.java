/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha.dao;

/**
 *
 * @author Fernando
 */
import com.mycompany.lojinha.database.Conexao;
import com.mycompany.lojinha.model.Produto;
import java.sql.*;
/* Resumindo a classe

A classe ProdutoDAO é responsável por salvar produtos no banco de dados.

O método cadastrarProduto recebe um objeto Produto através do parâmetro produto.

Em seguida, é criada uma conexão com o banco de dados e um objeto
PreparedStatement (stmt), que recebe o comando SQL.

Com o objeto produto, acessamos os métodos getNome(), getPreco() e
getEstoque() para preencher os parâmetros da consulta SQL.

Por fim, o comando é executado e os dados do produto são gravados
na tabela produtos do banco de dados MySQL.

Resumindo:
A classe ProdutoDAO transforma os dados de um objeto Produto em um
comando SQL e os salva no banco de dados.
*/

public class ProdutoDao {
    
    public void cadastrarProduto(Produto produto){
        try{
            Connection conn = Conexao.conectar(); //Aqui estou abrindo conexao com o banco
            
            String sql = "INSERT INTO produtos(nome,preco,quantidade)VALUES(?,?,?)";//
            
            PreparedStatement stmt = conn.prepareStatement(sql);/* criei um objeto stmt
            que vai receber como paramentro a variavel sql que nada mais é do que
            o comando sql
            */
            
            stmt.setString(1 ,produto.getNome());//Preenchendo os VALUES
            stmt.setDouble(2, produto.getPreco());//Preenchendo os VALUES
            stmt.setInt(3, produto.getEstoque());//Preenchendo os VALUES
            
            stmt.executeUpdate();//Esse comando que envia os dados pro sql
            
            stmt.close();
            conn.close();
            System.out.println("Produto cadastrado com sucesso");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    public void listarProdutos(){
        try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT * FROM produtos";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Preço: " + rs.getDouble("preco"));
            System.out.println("Estoque: " + rs.getInt("quantidade"));
            System.out.println("-------------------");
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }
    public ResultSet listarProdutosTabela() {

    try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT * FROM produtos";

        PreparedStatement stmt = conn.prepareStatement(sql);

        return stmt.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
    public void excluirProduto(int id) {
    /*
    O método excluirProduto recebe um id como parâmetro.
    Em seguida, cria um comando SQL DELETE com um parâmetro (?).

    O método setInt preenche esse parâmetro com o id informado.

    Por fim, executeUpdate executa o comando e remove o produto 
    correspondente da tabela produtos.
    */

    try {

        Connection conn = Conexao.conectar();

        String sql = "DELETE FROM produtos WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
        conn.close();

        System.out.println("Produto excluído com sucesso!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void atualizarProduto(int id, Produto produto) {

    try {

        Connection conn = Conexao.conectar();

        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);/*aqui estou preparando
        as informaçoes para uma execuçao.
        */

        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getEstoque());
        stmt.setInt(4, id);

        stmt.executeUpdate();//aqui eu executo

        stmt.close();//fecho as informaçoes
        conn.close();// fecho a conexao

        System.out.println("Produto atualizado com sucesso!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public Produto buscarProduto(String nome){
         try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT * FROM produtos WHERE nome = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
            );

            rs.close();
            stmt.close();
            conn.close();

            return produto;
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
    }

    public boolean realizarVenda(String nome, int quantidade) {

    try {

        Produto produto = buscarProduto(nome);

        if (produto == null) {
            return false;
        }

        if (produto.getEstoque() < quantidade) {
            return false;
        }

        int novoEstoque = produto.getEstoque() - quantidade;

        Connection conn = Conexao.conectar();

        String sql = "UPDATE produtos SET quantidade = ? WHERE nome = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, novoEstoque);
        stmt.setString(2, nome);

        stmt.executeUpdate();

        stmt.close();
        conn.close();

        return true;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
    
}
public int contarProdutos() {

    try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT COUNT(*) FROM produtos";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            int total = rs.getInt(1);

            rs.close();
            stmt.close();
            conn.close();

            return total;
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public int quantidadeTotalEstoque() {

    try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT SUM(quantidade) FROM produtos";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            int total = rs.getInt(1);

            rs.close();
            stmt.close();
            conn.close();

            return total;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public double valorTotalEstoque() {

    try {

        Connection conn = Conexao.conectar();

        String sql = "SELECT SUM(preco * quantidade) FROM produtos";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            double total = rs.getDouble(1);

            rs.close();
            stmt.close();
            conn.close();

            return total;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
  
}

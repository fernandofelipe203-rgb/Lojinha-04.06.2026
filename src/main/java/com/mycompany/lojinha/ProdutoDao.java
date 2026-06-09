/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha;

/**
 *
 * @author Fernando
 */
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
            
            String sql = "INSERT INTO produtos(nome,preco,estoque)VALUES(?,?,?)";//
            
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
            System.out.println("Estoque: " + rs.getInt("estoque"));
            System.out.println("-------------------");
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
        
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

        String sql = "UPDATE produtos SET nome = ?, preco = ?, estoque = ? WHERE id = ?";

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
}

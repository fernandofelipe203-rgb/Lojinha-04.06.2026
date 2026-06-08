/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha;

/**
 *
 * @author Administrador
 */
import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    String nome;
    
    
    public void exibirProduto(Produto produto){
        produto.exibirProduto();
        
    }
    public void exibirLoja(){
        System.out.println("===MERCADO NORONHA===");
    }
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
    public void listarProdutos(){
        for(Produto p : produtos){
            p.exibirProduto();
        }
    }
    public Produto buscarProduto(String nome){

    for(Produto p : produtos){
        if(p.getNome().equalsIgnoreCase(nome)){
            return p;
            }
        }
    return null;
    }
    public void realizarVenda(Cliente cliente, Produto produto, int quantidade){
        
        if(produto.vender(quantidade)){
        produto.exibirProduto();
        cliente.exibirCliente();
        System.out.println("Venda realizada com sucesso");
        }else{
        System.out.println("Venda Indisponivel");
        }
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public Loja(String nome) {
        this.nome = nome;
    }

    

   
    
    
    
}

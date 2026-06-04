/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha;

/**
 *
 * @author Administrador
 */
public class Loja {
    String nome;
    
    public void exibirProduto(Produto produto){
        produto.exibirProduto();
        
    }

    public void realizarVenda(Cliente cliente, Produto produto, int quantidade){
        produto.vender(quantidade);
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

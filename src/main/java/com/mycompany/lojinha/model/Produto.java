/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha.model;

/**
 *
 * @author Administrador
 */
public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected int quantidade;
 
    
public boolean vender(int quantidade) {
    if (estoque >= quantidade) {
        estoque -= quantidade;
        return true;
    }
    return false;
}
    public void reporEstoque(int quantidade){
           if(quantidade<=0){
           System.out.println("Quantidade invalida");
           return;
           }
           
           this.estoque+=quantidade;
           System.out.println("Estoque reposto com sucesso");

    }
    public void exibirProduto(){
        System.out.println("Nome do Produto: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Estoque: " + estoque);
    }
    


    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    
    
}

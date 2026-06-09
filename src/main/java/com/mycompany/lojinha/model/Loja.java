/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha.model;

/**
 *
 * @author Administrador
 */
import com.mycompany.lojinha.model.Produto;


public class Loja {

    
    private String nome;
    
    

    public void exibirLoja(){
        System.out.println("===MERCADO NORONHA===");
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

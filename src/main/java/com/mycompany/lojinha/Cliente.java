/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha;

/**
 *
 * @author Administrador
 */
public class Cliente {
    private String nome;
    private int idade;
    private char sexo;
    
    public void exibirCliente(){
        System.out.println("Nome do cliente: " + nome);
        System.out.println("idade: " + idade);
        System.out.println("sexo: " + sexo);
                
    }
    
    public Cliente(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + '}';
    }
 
    
}

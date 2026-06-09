/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha;

/**
 *
 * @author Administrador
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    
    Scanner sc =new Scanner(System.in);
    Loja loja = new Loja("Mercado do noronha");
    
    public void exibirMenu(){
        while (true){
        System.out.println(" ====MENU===== ");
        System.out.println(" 1- Cadastrar produto ");
        System.out.println(" 2- Realizar venda ");
        System.out.println(" 3- Mostrar produtos ");
        System.out.println(" 4- Sair ");
        
        System.out.println("Escolha uma opção");
        int opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("===CADASTRAR PRODUTO=== ");
                System.out.println("Digite o nome do produto que deseja cadastrar:  ");
                String nomeProduto = sc.nextLine();
                
                System.out.println("Preco:  ");
                double preco = sc.nextDouble();
                sc.nextLine();
                
                System.out.println("Quantidade: ");
                int quantidade = sc.nextInt();
                sc.nextLine();
                Produto produto = new Produto(nomeProduto,preco,quantidade);
                
                System.out.println("---Produto cadastrado com sucesso!---  ");
                loja.adicionarProduto(produto);
                
                break;
                
                
                
                
            
            case 2 :
                System.out.println("====BUSQUE O PRODUTO =====");
                loja.listarProdutos();
                System.out.print("Digite o nome do produto que deseja vender ");
                String nome = sc.nextLine();
                System.out.print("Quantidade: ");
                int quant = sc.nextInt();
                sc.nextLine();
                
                Produto produtoVenda = loja.buscarProduto(nome);
                
                if (produtoVenda != null){
                    loja.realizarVenda(produtoVenda,quant);
                }else{
                    System.out.println("Produto nao encontrado ou nao cadastrado");
                }
                
                break;
            
            case 3 :
                System.out.println("=====PRODUTOS =====");
                loja.listarProdutos();
                break;
            
            case 4 :
                System.out.println("Finalizando");
                return;
                
            default:
                System.out.println(" Opcao invalidada ");
                break;
            }   
        }
    }        
}
    
    


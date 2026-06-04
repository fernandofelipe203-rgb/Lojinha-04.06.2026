/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lojinha;

/**
 *
 * @author Fernando
 */
public class Main {

    public static void main(String[] args) {
        Loja loja = new Loja("Mercado Fernando");
        Produto mouse = new Produto("Mouse Gamer", 12.50 ,5);
        Produto pcGamer = new Produto("PC Gamer", 12000 ,4);
        
        Cliente cliente1 = new Cliente("maria",24,'F');
        Cliente cliente2 = new Cliente("joao",43,'M');
        
        loja.realizarVenda(cliente1, mouse, 2);
        loja.exibirProduto(mouse);
        cliente1.exibirCliente();
        System.out.println("=====================");
        
        loja.realizarVenda(cliente2, pcGamer, 1);
        loja.exibirProduto(pcGamer);
        
        cliente2.exibirCliente();
        
        
        
        
        
        
        
        
        
        
   



    
    }
}

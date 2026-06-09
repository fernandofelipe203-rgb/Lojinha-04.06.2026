/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lojinha;

/**
 *
 * @author Fernando
 */
import com.mycompany.lojinha.model.Loja;
import com.mycompany.lojinha.menu.Menu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Loja loja = new Loja("Mercado Fernando");
        Menu menu = new Menu();
        
        loja.exibirLoja();
        menu.exibirMenu();
        
 
        
        System.out.println("=====================");
        


    
    }
}

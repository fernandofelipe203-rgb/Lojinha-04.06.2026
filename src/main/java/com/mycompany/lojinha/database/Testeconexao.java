/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojinha.database;

import com.mycompany.lojinha.database.Conexao;
import java.sql.Connection;

/**
 *
 * @author Administrador
 */
public class Testeconexao {
     public static void main(String[] args) {

        try {

            Connection conn = Conexao.conectar();

            System.out.println("Conectado ao MySQL com sucesso!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Erro ao conectar:");
            e.printStackTrace();

        }

    }
    
}

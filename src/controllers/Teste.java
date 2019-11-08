/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.List;
import models.Usuario;

/**
 *
 * @author renan
 */
public class Teste {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        UsuarioController usuario = new UsuarioController();
        List<Usuario> users = usuario.listar();
        for(Usuario user : users){
            System.out.println(user.getId());
            System.out.println(user.getNome());
            System.out.println("");
        }

        
       
    }
}

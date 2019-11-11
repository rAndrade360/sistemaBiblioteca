/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import models.Livro;
import models.Usuario;

/**
 *
 * @author renan
 */
public class Teste {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        ServicosController servico = new ServicosController();
        LocalDate data = LocalDate.now();
        servico.emprestar(1, "20191ergdf");
    }
}

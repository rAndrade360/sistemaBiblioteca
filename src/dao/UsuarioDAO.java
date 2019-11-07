/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Usuario;

/**
 *
 * @author renan
 */
public class UsuarioDAO {
    private final Connection connection;
    
    public UsuarioDAO() throws ClassNotFoundException{
        this.connection = Database.connect();
    }
    
    public void insert(Usuario usuario) throws SQLException{
        String query = "INSERT INTO usuarios (nome, matricula, sexo, cpf, telefone, email, celular, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getMatricula());
        stmt.setString(3, usuario.getSexo());
        stmt.setInt(4, usuario.getCpf());
        stmt.setInt(5, usuario.getTelefone());
        stmt.setString(6, usuario.getEmail());
        stmt.setInt(7, usuario.getCelular());
        stmt.setDate(8, Date.valueOf(usuario.getNascimento()));
        
    }
}

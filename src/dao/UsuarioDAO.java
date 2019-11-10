/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        String query = "INSERT INTO usuarios(nome, matricula, sexo, cpf, telefone, email, celular, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getMatricula());
        stmt.setString(3, usuario.getSexo());
        stmt.setInt(4, usuario.getCpf());
        stmt.setInt(5, usuario.getTelefone());
        stmt.setString(6, usuario.getEmail());
        stmt.setInt(7, usuario.getCelular());
        stmt.setDate(8, Date.valueOf(usuario.getNascimento()));
        System.out.println("oi" + usuario.getCelular());
        stmt.execute();
        stmt.close();
        
    }
    
    public List<Usuario> listAll() throws SQLException{
        List<Usuario> users = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        ResultSet result;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            result = stmt.executeQuery();
            while(result.next()){
                Usuario user = new Usuario();
                user.setId(result.getInt("id"));
                user.setNome(result.getString("nome"));
                user.setMatricula(result.getString("matricula"));
                user.setSexo(result.getString("sexo"));
                user.setCpf(result.getInt("cpf"));
                user.setTelefone(result.getInt("telefone"));
                user.setEmail(result.getString("email"));
                user.setCelular(result.getInt("celular"));
                LocalDate date = result.getDate("data_nascimento").toLocalDate();
                user.setNascimento(date);
                
                users.add(user);
            }
        }
        result.close();
        return users;     
    }
    
    public Usuario show(String matricula) throws SQLException{
        String query = "SELECT * FROM usuarios WHERE matricula = ? LIMIT 1";
        PreparedStatement stmt = connection.prepareCall(query);
        stmt.setString(1, matricula);
        Usuario user;
        try (ResultSet result = stmt.executeQuery()) {
            user = new Usuario();
            while(result.next()){
                
                user.setId(result.getInt("id"));
                user.setNome(result.getString("nome"));
                user.setMatricula(result.getString("matricula"));
                user.setSexo(result.getString("sexo"));
                user.setCpf(result.getInt("cpf"));
                user.setTelefone(result.getInt("telefone"));
                user.setEmail(result.getString("email"));
                user.setCelular(result.getInt("celular"));
                LocalDate date = result.getDate("data_nascimento").toLocalDate();
                user.setNascimento(date);
            }
        }
        return user;
    }
    
    public void update(Usuario usuario) throws SQLException{
        String query = "UPDATE usuarios SET nome=?, matricula = ?, sexo=?, cpf=?, telefone=?, email=?, celular=?, data_nascimento=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getMatricula());
        stmt.setString(3, usuario.getSexo());
        stmt.setInt(4, usuario.getCpf());
        stmt.setInt(5, usuario.getTelefone());
        stmt.setString(6, usuario.getEmail());
        stmt.setInt(7, usuario.getCelular());
        stmt.setDate(8, Date.valueOf(usuario.getNascimento()));
        stmt.setLong(9, usuario.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void delete(Usuario usuario) throws SQLException{
        String query = "DELETE FROM usuarios WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, usuario.getId());
            stmt.execute();
        }
    }
    
    
}
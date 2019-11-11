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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void insert(Usuario usuario) {
        try {
            String query = "INSERT INTO usuarios(nome, matricula, sexo, cpf, telefone, email, celular, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getSexo());
            stmt.setLong(4, usuario.getCpf());
            stmt.setLong(5, usuario.getTelefone());
            stmt.setString(6, usuario.getEmail());
            stmt.setLong(7, usuario.getCelular());
            stmt.setDate(8, Date.valueOf(usuario.getNascimento()));
            System.out.println("oi" + usuario.getCelular());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    
    public List<Usuario> listAll() {
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
                user.setCpf(result.getLong("cpf"));
                user.setTelefone(result.getLong("telefone"));
                user.setEmail(result.getString("email"));
                user.setCelular(result.getLong("celular"));
                LocalDate date = result.getDate("data_nascimento").toLocalDate();
                user.setNascimento(date);
                
                users.add(user);
                  result.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return users;     
    }
    
    public Usuario show(String matricula){
        try {
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
                    user.setCpf(result.getLong("cpf"));
                    user.setTelefone(result.getLong("telefone"));
                    user.setEmail(result.getString("email"));
                    user.setCelular(result.getLong("celular"));
                    LocalDate date = result.getDate("data_nascimento").toLocalDate();
                    user.setNascimento(date);
                }
            }
            return user;
        }   catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(Usuario usuario){
        try {
            String query = "UPDATE usuarios SET nome=?, matricula = ?, sexo=?, cpf=?, telefone=?, email=?, celular=?, data_nascimento=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getSexo());
            stmt.setLong(4, usuario.getCpf());
            stmt.setLong(5, usuario.getTelefone());
            stmt.setString(6, usuario.getEmail());
            stmt.setLong(7, usuario.getCelular());
            stmt.setDate(8, Date.valueOf(usuario.getNascimento()));
            stmt.setLong(9, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Usuario usuario){
        String query = "DELETE FROM usuarios WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, usuario.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

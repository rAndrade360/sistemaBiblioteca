/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Bibliotecario;


/**
 *
 * @author renan
 */
public class BibliotecarioDAO {
    private final Connection connection;
    
    public BibliotecarioDAO() throws ClassNotFoundException{
        this.connection = Database.connect();
    }
    
    public void insert(Bibliotecario bibliotecario){
        try {
            String query = "INSERT INTO bibliotecarios(nome, matricula, sexo, cpf, telefone, senha) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, bibliotecario.getNome());
            stmt.setString(2, bibliotecario.getMatricula());
            stmt.setString(3, bibliotecario.getSexo());
            stmt.setLong(4, bibliotecario.getCpf());
            stmt.setLong(5, bibliotecario.getTelefone());
            stmt.setString(6, bibliotecario.getSenha());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Bibliotecario> listAll() {
        List<Bibliotecario> bibliotecarios = new ArrayList<>();
        String query = "SELECT * FROM bibliotecarios";
        ResultSet result;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            result = stmt.executeQuery();
            while(result.next()){
                Bibliotecario bibliotecario = new Bibliotecario();
                bibliotecario.setId(result.getInt("id"));
                bibliotecario.setNome(result.getString("nome"));
                bibliotecario.setMatricula(result.getString("matricula"));
                bibliotecario.setSexo(result.getString("sexo"));
                bibliotecario.setCpf(result.getLong("cpf"));
                bibliotecario.setTelefone(result.getLong("telefone"));
                bibliotecario.setSenha(result.getString("senha"));               
                bibliotecarios.add(bibliotecario);
                stmt.close();
                 result.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return  bibliotecarios;     
    }
    
    public Bibliotecario show(int id){
        try {
            String query = "SELECT * FROM bibliotecarios WHERE id = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, id);
            Bibliotecario bibliotecario;
            try (ResultSet result = stmt.executeQuery()) {
                bibliotecario = new Bibliotecario();
                while(result.next()){
                    
                    bibliotecario.setId(result.getInt("id"));
                    bibliotecario.setNome(result.getString("nome"));
                    bibliotecario.setMatricula(result.getString("matricula"));
                    bibliotecario.setSexo(result.getString("sexo"));
                    bibliotecario.setCpf(result.getLong("cpf"));
                    bibliotecario.setTelefone(result.getLong("telefone"));
                    bibliotecario.setSenha(result.getString("senha"));
                }
            }
            return bibliotecario;
        }   catch (SQLException ex) {
            Logger.getLogger(BibliotecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(Bibliotecario bibliotecario){
        try {
            String query = "UPDATE bibliotecarios SET nome=?, matricula = ?, sexo=?, cpf=?, telefone=?, senha=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, bibliotecario.getNome());
            stmt.setString(2, bibliotecario.getMatricula());
            stmt.setString(3, bibliotecario.getSexo());
            stmt.setLong(4, bibliotecario.getCpf());
            stmt.setLong(5, bibliotecario.getTelefone());
            stmt.setString(6, bibliotecario.getSenha());
            stmt.setLong(7, bibliotecario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Bibliotecario bibliotecario){
        String query = "DELETE FROM bibliotecarios WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, bibliotecario.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(Bibliotecario bibliotecario){
        try {
            String query = "SELECT * FROM bibliotecarios WHERE matricula = ? and senha = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, bibliotecario.getMatricula());
            stmt.setString(2, bibliotecario.getSenha());
            ResultSet res = stmt.executeQuery();
            boolean next = res.next();
            res.close();
            stmt.close();
            return next;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao logar!");
        }
        return false;
    }
    
}

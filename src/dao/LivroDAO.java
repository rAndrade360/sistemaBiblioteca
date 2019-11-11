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
import models.Livro;


/**
 *
 * @author renan
 */
public class LivroDAO {
    private final Connection connection;
    
    public LivroDAO() throws ClassNotFoundException{
        this.connection = Database.connect();
    }
    public void insert(Livro livro) {
        String query = "INSERT INTO livros(autor, titulo, ano, editora) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, livro.getAutor());
            stmt.setString(2, livro.getTitulo());
            stmt.setInt(3, livro.getAno());
            stmt.setString(4, livro.getEditora());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Livro> listAll() {
        List<Livro> books = new ArrayList<>();
        String query = "SELECT * FROM livros";
        ResultSet result;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            result = stmt.executeQuery();
            while(result.next()){
                Livro livro = new Livro();
                livro.setId(result.getInt("id"));
                livro.setAutor(result.getString("autor"));
                livro.setTitulo(result.getString("titulo"));
                livro.setAno(result.getInt("ano"));
                livro.setEditora(result.getString("editora"));
                
                books.add(livro);
                stmt.close();
                result.close();
                 return books;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    public Livro show(int codigo){
        try {
            String query = "SELECT * FROM livros WHERE id=? LIMIT 1";
            PreparedStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, codigo);
            Livro livro;
            try (ResultSet result = stmt.executeQuery()) {
                livro = new Livro();
                while(result.next()){
                    
                    livro.setId(result.getInt("id"));
                    livro.setAutor(result.getString("autor"));
                    livro.setTitulo(result.getString("titulo"));
                    livro.setAno(result.getInt("ano"));
                    livro.setEditora(result.getString("editora"));
                }
            }
            return livro;
        }   catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(Livro livro){
        try {
            String query = "UPDATE livros SET autor=?, titulo = ?, ano=?, editora=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, livro.getAutor());
            stmt.setString(2, livro.getTitulo());
            stmt.setInt(3, livro.getAno());
            stmt.setString(4, livro.getEditora());
            stmt.setInt(5, livro.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Livro livro){
        String query = "DELETE FROM livros WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, livro.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

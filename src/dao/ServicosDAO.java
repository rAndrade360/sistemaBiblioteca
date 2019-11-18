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
import javax.swing.JOptionPane;
import models.Emprestimo;
import models.Livro;
import models.Reserva;
import models.Usuario;

/**
 *
 * @author renan
 */
public class ServicosDAO {
     private final Connection connection;
    
    public ServicosDAO() throws ClassNotFoundException{
        this.connection = Database.connect();
    }
    
    public void emprestar(Emprestimo emprestimo) {
         try {
             
             String query = "INSERT INTO emprestimos(usuario_id, livro_id, data_emprestimo, data_devolucao) VALUES(?, ?, ?, ?)";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, emprestimo.getUsuario().getId());
             stmt.setInt(2, emprestimo.getLivro().getId());
             LocalDate date = LocalDate.now();
             stmt.setDate(3, Date.valueOf(date));
             stmt.setDate(4, Date.valueOf(emprestimo.getData_devolucao()));
             stmt.execute();
             stmt.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro "+ ex);
         }
    }
    
    public boolean buscar(Livro livro){
          
         try {
             String query = "SELECT * FROM emprestimos e WHERE (livro_id = ?) and (e.id NOT IN (SELECT emprestimo_id FROM devolucoes)) LIMIT 1";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, livro.getId());
             ResultSet rs = stmt.executeQuery();
             boolean emp = rs.next();
             return emp;
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro "+ ex);
         }
        return false;
    }
   
   
    
     public Emprestimo buscarEmprestimo(Livro livro){
          Emprestimo emp = new Emprestimo();
         try {
             String query = "SELECT * FROM emprestimos e WHERE (livro_id = ?) and (e.id NOT IN (SELECT emprestimo_id FROM devolucoes)) LIMIT 1";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, livro.getId());
             ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                   emp.setId(rs.getInt("id"));
             }
             return emp;
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro "+ ex);
         }
        return emp;
    }
   
     public List<Emprestimo> listaEmprestimos(){
         List<Emprestimo> lista = new ArrayList<Emprestimo>();
         try {
             String query = "SELECT * FROM emprestimos e WHERE e.id NOT IN (SELECT emprestimo_id FROM devolucoes)";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                  Emprestimo emp = new Emprestimo();
                  Usuario user = new Usuario();
                  Livro book = new Livro();
                  emp.setId(rs.getInt("id"));
                  user.setId(rs.getInt("usuario_id"));
                  book.setId(rs.getInt("livro_id"));
                  emp.setData_devolucao(rs.getDate("data_devolucao").toLocalDate());
                  emp.setData_emprestimo(rs.getDate("data_emprestimo").toLocalDate());
                  emp.setLivro(book);
                  emp.setUsuario(user);
                  lista.add(emp);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro "+ ex);
         }
        return lista;
     }
   
    
    
    
    public void devolver(Emprestimo emprestimo){
         try {
             String query = "INSERT INTO devolucoes(emprestimo_id, data_devolucao) VALUES(?, ?)";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, emprestimo.getId());
             LocalDate date = LocalDate.now();
             stmt.setDate(2, Date.valueOf(date));
             stmt.execute();
             stmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void reservar(Reserva reserva) {
         try {
             String query = "INSERT INTO reservas(usuario_id, livro_id, data_reserva) VALUES(?, ?, ?)";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, reserva.getUsuario().getId());
             stmt.setInt(2, reserva.getLivro().getId());
             stmt.setDate(3, Date.valueOf(reserva.getData()));
             stmt.execute();
             stmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
       
    public boolean isReserved(Livro livro, Usuario usuario){
         try {
             String quey = "SELECT * FROM reservas WHERE livro_id = ? and usuario_id = ? and emprestado = false LIMIT 1";
             PreparedStatement stmt = this.connection.prepareStatement(quey);
             stmt.setInt(1, livro.getId());
             stmt.setInt(2, usuario.getId());
             ResultSet res = stmt.executeQuery();
             boolean next = res.next();
           return next;
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           return false;
    }
    
    public boolean isReserved(Livro livro){
         try {
             String quey = "SELECT * FROM reservas WHERE livro_id = ? and emprestado = false LIMIT 1";
             PreparedStatement stmt = this.connection.prepareStatement(quey);
             stmt.setInt(1, livro.getId());
             ResultSet res = stmt.executeQuery();
             boolean next = res.next();
           return next;
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           return false;
    }
 
    
    public void setReserve(Livro livro){
         try {
             String quey = "UPDATE reservas SET emprestado = true WHERE livro_id = ? and emprestado = false";
             PreparedStatement stmt = this.connection.prepareStatement(quey);
             stmt.setInt(1, livro.getId());
             stmt.execute();
             stmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             
         }
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Emprestimo;
import models.Reserva;

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
             
             String query = "INSERT INTO emprestimos(usuario_id, livro_id, data_emprestimo) VALUES(?, ?, ?)";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, emprestimo.getUsuario().getId());
             stmt.setInt(2, emprestimo.getLivro().getId());
             LocalDate date = LocalDate.now();
             stmt.setDate(3, Date.valueOf(date));
             stmt.execute();
             stmt.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro "+ ex);
         }
    }
    
    public Emprestimo buscar(Emprestimo emprestimo){
          Emprestimo emp = new Emprestimo();
         try {
           
             String query = "SELECT * FROM emprestimos e WHERE (livro_id = ?) and (e.id NOT IN (SELECT emprestimo_id FROM devolucoes)) LIMIT 1";
             PreparedStatement stmt = this.connection.prepareStatement(query);
             stmt.setInt(1, emprestimo.getLivro().getId());
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
}

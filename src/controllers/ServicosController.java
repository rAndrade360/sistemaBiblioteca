/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ServicosDAO;
import java.time.LocalDate;
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
public class ServicosController {
    public void emprestar(int codigo, String matricula) {
        try {
            UsuarioController user = new UsuarioController();
            Usuario usuario = user.buscar(matricula);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            
            
            
            ServicosDAO servicos = new ServicosDAO();
            Emprestimo emp = servicos.buscar(emprestimo);
            
            if(emp.getId() == 0){
                 servicos.emprestar(emprestimo);
                 JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
            }
            System.out.println(emp.getId());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação!");
        }
        
    }
    
    
    public void devolver(int codigo, String matricula){
        try {
           UsuarioController user = new UsuarioController();
            Usuario usuario = user.buscar(matricula);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            
            
            
            ServicosDAO servicos = new ServicosDAO();
            Emprestimo emp = servicos.buscar(emprestimo);
            
            
            if(emp.getId() == 0){
               JOptionPane.showMessageDialog(null, "O registro do empréstimo não existe!");
            }else{
                emp.setLivro(livro);
                emp.setUsuario(usuario);
                 servicos.devolver(emp);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void reservar(int codigo,String matricula, LocalDate data){
        try {
            UsuarioController user = new UsuarioController();
            Usuario usuario = user.buscar(matricula);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            
            ServicosDAO servicos = new ServicosDAO();
            Emprestimo emp = servicos.buscar(emprestimo);
            
            if(emp.getId() == 0){
                Reserva reserva = new Reserva();
                reserva.setUsuario(usuario);
                reserva.setLivro(livro);
                reserva.setData(data);
                 servicos.reservar(reserva);
            }else{
                System.out.println(emp.getId());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

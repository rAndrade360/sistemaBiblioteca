package controllers;
import dao.BibliotecarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Bibliotecario;
/**
 *
 * @author renan
 */
public class BibliotecarioController {
    
     public void cadastrar(Bibliotecario bibliotecario){
         try {   
             BibliotecarioDAO bibliote = new BibliotecarioDAO();
             bibliote.insert(bibliotecario);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BibliotecarioController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public List listar(){
         try {
             BibliotecarioDAO bibliote = new BibliotecarioDAO();
             return bibliote.listAll();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BibliotecarioController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
    public Bibliotecario buscar(int id){
         try {
             BibliotecarioDAO bibliote = new BibliotecarioDAO();
             return bibliote.show(id);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BibliotecarioController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
    public void atualizar(Bibliotecario bibliotecario){
         try {
             BibliotecarioDAO bibliote = new BibliotecarioDAO();
             bibliote.update(bibliotecario);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BibliotecarioController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void deletar(Bibliotecario bibliotecario){
         try {
             BibliotecarioDAO bibliote = new BibliotecarioDAO();
             bibliote.delete(bibliotecario);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BibliotecarioController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public boolean login(String matricula, String senha){
         try {
             Bibliotecario bibliotecario = new Bibliotecario();
             bibliotecario.setMatricula(matricula);
             bibliotecario.setSenha(senha);
             BibliotecarioDAO biblio = new BibliotecarioDAO();
             boolean log = biblio.login(bibliotecario);
             return log;
         } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "Erro de Conexão!");
         }
         return false;
    }
}

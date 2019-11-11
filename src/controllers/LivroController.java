package controllers;
import dao.LivroDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Livro;
/**
 *
 * @author renan
 */
public class LivroController {
    
  public void cadastrar(Livro livro){
      try {
          LivroDAO book = new LivroDAO();
          book.insert(livro);
          JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
      } catch (ClassNotFoundException ex) {
          //Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, "Não foi possível cadastrar "+ ex);
      }
    }
    
    public List listar(){
      try {
          LivroDAO book = new LivroDAO();
          return book.listAll();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
    }
    
    public Livro buscar(int codigo){
      try {
          LivroDAO book = new LivroDAO();
         return book.show(codigo);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
      }
       return null;
    }
    
    public void atualizar(Livro livro){
      try {
          LivroDAO book = new LivroDAO();
          book.update(livro);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void deletar(Livro livro){
      try {
          LivroDAO book = new LivroDAO();
          book.delete(livro);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }   
}

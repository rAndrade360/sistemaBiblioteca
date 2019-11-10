package controllers;
import dao.LivroDAO;
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
    
    public void listar(){
        
    }
    
    public void buscar(String codigo){
        
    }
    
    public void atualizar(String codigo, Livro livro){
        
    }
    
    public void deletar(String codigo){
        
    }   
}

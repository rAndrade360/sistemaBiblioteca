package controllers;
import dao.UsuarioDAO;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Usuario;

/**
 *
 * @author renan
 */
public class UsuarioController {
    
           

    public UsuarioController(){
       
        
    }
    
    public void cadastrar(Usuario usuario) {
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
                usuarioDAO.insert(usuario);
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public List<Usuario> listar() {
        try {
            UsuarioDAO usuario = new UsuarioDAO();
            return usuario.listAll();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario buscar(Usuario usuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            return usuarioDAO.show(usuario);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    public void atualizar(Usuario usuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.update(usuario);
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar(Usuario usuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario user = usuarioDAO.show(usuario);
                usuarioDAO.delete(user);
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Não foi possível remover usuário");
        }
    }
}

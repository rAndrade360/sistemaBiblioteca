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
    
    public List listar() {
        try {
            UsuarioDAO usuario = new UsuarioDAO();
            return usuario.listAll();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario buscar(String matricula) throws ClassNotFoundException{
        UsuarioDAO usuario = new UsuarioDAO();
        try {
            return usuario.show(matricula);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar usuário");
        }
        return null;
    }
    
    public void atualizar(Usuario usuario) throws ClassNotFoundException{
         UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.update(usuario);
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível alterar usuário");
        }
    }
    
    public void deletar(Usuario usuario) throws ClassNotFoundException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.delete(usuario);
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível remover usuário");
        }
    }
}

package controllers;
import dao.UsuarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Usuario;

/**
 *
 * @author renan
 */
public class UsuarioController {
    
    public UsuarioController(){
       
        
    }
    
    public void cadastrar(Usuario usuario) throws ClassNotFoundException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try{
        usuarioDAO.insert(usuario);
        JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
        }
    }
    
    public void listar(){
        
    }
    
    public void buscar(String matricula){
        
    }
    
    public void atualizar(String matricula, Usuario usuario){
        
    }
    
    public void deletar(String matricula){
        
    }
}


package controllers;

import dao.ServicosDAO;
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
public class ServicosController {
    public void emprestar(int codigo, Usuario usu, LocalDate devolucao) {
        try {
            UsuarioController user = new UsuarioController();
            Usuario usuario = user.buscar(usu);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            emprestimo.setData_devolucao(devolucao);
            
            
            ServicosDAO servicos = new ServicosDAO();
           boolean notdevolvido = servicos.buscar(livro);
            
            if(!notdevolvido){
                if((servicos.isReserved(livro) && servicos.isReserved(livro, usuario)) || !servicos.isReserved(livro)  ){
                 servicos.emprestar(emprestimo);
                 JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Livro não disponível!");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "Livro não disponível!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação!");
        }
        
    }
    
    
    public void devolver(int codigo, Usuario usu){
        try {
           UsuarioController user = new UsuarioController();
            Usuario usuario = user.buscar(usu);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            
            
            
            ServicosDAO servicos = new ServicosDAO();
            boolean notdevolvido = servicos.buscar(livro);
            
            
            if(notdevolvido){
                  Emprestimo emp = servicos.buscarEmprestimo(livro);
                emp.setLivro(livro);
                emp.setUsuario(usuario);
                 servicos.devolver(emp);

            }else{
                             JOptionPane.showMessageDialog(null, "O registro do empréstimo não existe!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void reservar(int codigo,Usuario usu, LocalDate data){
        try {
            UsuarioController user = new UsuarioController();
            
            Usuario usuario = user.buscar(usu);
            
            LivroController book = new LivroController();
            Livro livro = book.buscar(codigo);
            
            Emprestimo emprestimo = new Emprestimo();
            
            emprestimo.setUsuario(usuario);
            emprestimo.setLivro(livro);
            
            ServicosDAO servicos = new ServicosDAO();
            boolean notdevolvido = servicos.buscar(livro);
            
            if(!notdevolvido){
                JOptionPane.showMessageDialog(null, "O livro está disponível na biblioteca");
            }else if(servicos.isReserved(livro)){
                JOptionPane.showMessageDialog(null, "O livro já está reservado!");   
            }else{
                Reserva reserva = new Reserva();
                reserva.setUsuario(usuario);
                reserva.setLivro(livro);
                reserva.setData(data);
                 servicos.reservar(reserva);
                    JOptionPane.showMessageDialog(null, "Livro reservado com sucesso!");   
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public List<Emprestimo> listaEmprestimos(){
       
        List<Emprestimo> lista = new ArrayList<Emprestimo>();
        List<Emprestimo> novaLista = new ArrayList<Emprestimo>();
        try {
            ServicosDAO servicos = new ServicosDAO();
            lista = servicos.listaEmprestimos();
            
            for(Emprestimo emp : lista){
                UsuarioController usuario = new UsuarioController();
                Usuario user = emp.getUsuario();
                emp.setUsuario(usuario.buscar(user));
                
                LivroController livro = new LivroController();
                Livro book = emp.getLivro();
                book = livro.buscar(book.getId());
                emp.setLivro(book);
                
                novaLista.add(emp);     
            }
           return novaLista;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
}




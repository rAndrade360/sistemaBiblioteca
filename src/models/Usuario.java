
package models;

import java.time.LocalDate;


/**
 *
 * @author renan
 */
public class Usuario extends Pessoa {
    private String email;
    private long celular;
    private LocalDate nascimento;
    
    public Usuario(){
        
    }

    public Usuario(String nome, String sexo,String matricula, long cpf, long telefone, LocalDate nascimento) {
        super(nome, matricula, sexo,cpf, telefone);
        this.nascimento = nascimento;
    }
    
     public Usuario(String nome, String matricula, String sexo,long cpf, LocalDate nascimento){
        super(nome, matricula, sexo,cpf);
        this.nascimento = nascimento;
    }

    public Usuario(String email, long celular, String sexo,LocalDate nascimento, String nome, String matricula, long cpf, long telefone) {
        super(nome, matricula, sexo,cpf, telefone);
        this.email = email;
        this.celular = celular;
        this.nascimento = nascimento;
    }
    
    

    public void setEmail(String email){
        this.email= email;
    }
    
    public String getEmail(){
        return this.email;
    }

 
    public void setCelular(long celular){
        this.celular = celular;
    }
    
    public long getCelular(){
        return this.celular;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
}

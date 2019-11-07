
package models;

import java.time.LocalDate;


/**
 *
 * @author renan
 */
public class Usuario extends Pessoa {
    private String email;
    private int celular;
    private LocalDate nascimento;

    public Usuario(String nome, String sexo,String matricula, int cpf, int telefone, LocalDate nascimento) {
        super(nome, matricula, sexo,cpf, telefone);
        this.nascimento = nascimento;
    }
    
     public Usuario(String nome, String matricula, String sexo,int cpf, LocalDate nascimento){
        super(nome, matricula, sexo,cpf);
        this.nascimento = nascimento;
    }

    public Usuario(String email, int celular, String sexo,LocalDate nascimento, String nome, String matricula, int cpf, int telefone) {
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

 
    public void setCelular(int celular){
        this.celular = celular;
    }
    
    public int getCelular(){
        return this.celular;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
}

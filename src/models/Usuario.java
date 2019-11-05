
package models;

import java.time.LocalDate;


/**
 *
 * @author renan
 */
public class Usuario extends Pessoa {
    private String email;
    private String endereco;
    private int celular;
    private LocalDate nascimento;

    public Usuario(int id, String nome, String matricula, int cpf, int telefone) {
        super(id, nome, matricula, cpf, telefone);
    }
    
     public Usuario(int id, String nome, String matricula, int cpf){
        super(id, nome, matricula, cpf);
    }

    public Usuario(String email, String endereco, int celular, LocalDate nascimento, int id, String nome, String matricula, int cpf, int telefone) {
        super(id, nome, matricula, cpf, telefone);
        this.email = email;
        this.endereco = endereco;
        this.celular = celular;
        this.nascimento = nascimento;
    }
    
    

    public void setEmail(String email){
        this.email= email;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getEndereco(){
        return this.endereco;
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

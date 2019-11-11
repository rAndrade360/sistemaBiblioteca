
package models;

/**
 *
 * @author renan
 */
public class Bibliotecario extends Pessoa{
    private String senha;
    public Bibliotecario(){
        
    }
    public Bibliotecario(String nome, String matricula, String sexo,int cpf, long telefone, String senha){
        super(nome, matricula, sexo, cpf, telefone);
        this.senha = senha;
    }

    public Bibliotecario( String nome, String matricula, String sexo, int cpf, String senha){
        super(nome, matricula, sexo, cpf);
        this.senha = senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
}

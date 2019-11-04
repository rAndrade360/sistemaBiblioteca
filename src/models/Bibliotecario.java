
package models;

/**
 *
 * @author renan
 */
public class Bibliotecario extends Pessoa{
    private String senha;
    public Bibliotecario(int id, String nome, String matricula, int cpf, int telefone, String senha){
        super(id, nome, matricula, cpf, telefone);
        this.senha = senha;
    }

    public Bibliotecario(int id, String nome, String matricula, int cpf, String senha){
        super(id, nome, matricula, cpf);
        this.senha = senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
}

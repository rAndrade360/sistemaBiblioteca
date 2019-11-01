
package models;

/**
 *
 * @author renan
 */
public class Pessoa {
    private int id;
    private String nome;
    private String matricula;
    private int cpf;
    private int telefone;

    
    public void setId(int id){
        this.id = id;
    }
    
    public int getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getMatricula(){
        return this.matricula;
    }

    public void setCpf(int cpf){
        this.cpf = cpf;
    }
    
    public int getCpf(){
        return this.cpf;
    }
    
       public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public int getTelefone(){
        return this.telefone;
    }

}

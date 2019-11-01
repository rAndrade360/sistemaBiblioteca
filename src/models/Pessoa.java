
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
   

    public Pessoa(int id, String nome, String matricula, int cpf, int telefone){
        this.id = id;
        this.nome = nome;
        this.matricula = matricula,
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Pessoa(int id, String nome, String matricula, int cpf){
        this.id = id;
        this.nome = nome;
        this.matricula = matricula,
        this.cpf;
    }
    
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


package models;

/**
 *
 * @author renan
 */
public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String matricula;
    protected long cpf;
    protected long telefone;
    protected String sexo;
   
    public Pessoa(){
        
    }

    public Pessoa(String nome, String matricula, String sexo, long cpf, long telefone){
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public Pessoa(String nome, String matricula, String sexo, long cpf){
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.sexo = sexo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getMatricula(){
        return this.matricula;
    }

    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    
    public long getCpf(){
        return this.cpf;
    }
    
       public void setTelefone(long telefone){
        this.telefone = telefone;
    }
    
    public long getTelefone(){
        return this.telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    

}

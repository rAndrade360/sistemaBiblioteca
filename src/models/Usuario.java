
package models;

/**
 *
 * @author renan
 */
public class Usuario extends Pessoa {
    private String turma;
    private String endereco;
    private int celular;
    private Date nascimento;
    

    public void setTurma(String turma){
        this.turma = turma;
    }
    
    public String getTurma(){
        return this.turma;
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
}

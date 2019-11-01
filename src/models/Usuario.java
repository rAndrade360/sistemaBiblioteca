/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author renan
 */
public class Usuario {
    private String nome;
    private String matricula;
    private int cpf;
    private String turma;
    private String endereco;
    private int telefone;
    private int celular;

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
    
    public String getCpf(){
        return this.cpf;
    }
}

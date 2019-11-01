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
public class Livro {
    private String autor;
    private String titulo;
    private String subtitulo;
    private int ano;
    private String editora;
    private int volume;
    
     public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getAutor(){
        return this.autor;
    }

     public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return this.titulo;
    }

}

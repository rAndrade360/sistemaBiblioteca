
package models;

/**
 *
 * @author renan
 */
public class Livro {
    private int id;
    private String autor;
    private String titulo;
    private int ano;
    private String editora;
    public Livro() {
    }
    
    

    public Livro(String autor, String titulo, int ano, String editora){
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
    }
 
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

    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public String getEditora(){
        return this.editora;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

 


}


package models;

/**
 *
 * @author renan
 */
public class Livro {
    private int id;
    private String autor;
    private String titulo;
    private String subtitulo;
    private int ano;
    private String editora;
    private int volume;

    public Livro(int id, String autor, String titulo, String subtitulo, int ano, String editora, int volume){
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.subtitulo;
        this.ano = ano;
        this.editora = editora;
        this.volume = volume;
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

    public void setSubtitulo(String subtitulo){
        this.subtitulo = subtitulo;
    }
    
    public String getSubtitulo(){
        return this.subtitulo;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public String getEditora(){
        return this.editora;
    }

    public void setVolume(String volume){
        this.volume = volume;
    }
    
    public String getVolume(){
        return this.volume;
    }

}

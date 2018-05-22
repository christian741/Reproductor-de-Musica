/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloAlbum;


/**
 *
 * @author Familia Díaz Rendón
 */
public class Albums {
      private String nombre,artista,genero,imagen;
      
      

    
    /**
    * 
    * @param nombre
    * @param artista
    * @param genero
    * @param imagen 
    */
    public Albums(String nombre, String artista, String genero, String imagen) {
            this.nombre = nombre;
            this.artista = artista;
            this.genero = genero;
            this.imagen = imagen;
    }
        
    public static Albums crear(String nombre, String artista, String genero, String imagen) {
        return new Albums(nombre,artista,genero,imagen);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    public String getImagen() {
        return imagen;
    }
    
  
    
    
    
}

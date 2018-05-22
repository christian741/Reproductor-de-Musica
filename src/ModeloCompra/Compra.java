/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCompra;


/**
 *
 * @author Familia Díaz Rendón
 */
public class Compra {
    private int id = 0,documento;
    private String  nombre,cancion,album; 

    public Compra(int id,int documento, String nombre, String cancion, String album) {
        this.id=id;
        this.documento = documento;
        this.nombre = nombre;
        this.cancion = cancion;
        this.album = album;
    }
    
    public static Compra crear(int id,int documento, String nombre, String cancion, String album) {
        return new Compra(id,documento, nombre,  cancion,album);
    }

    public Compra() {
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCancion() {
        return cancion;
    }

    public String getAlbum() {
        return album;
    }
    
}

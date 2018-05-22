/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCancion;

import BaseDatos.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Familia Díaz Rendón
 */
public class Cancion {

  
    private String cancion, nombreAlbum,ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    private int minutos,segundos, calidad, tamaño;
    private static BaseDatos database = new BaseDatos();
    
    public Cancion(String cancion, String nombreAlbum, int minutos, int segundos, int calidad, int tamaño,String ruta) {
        this.cancion = cancion;
        this.nombreAlbum = nombreAlbum;
        this.minutos = minutos;
        this.segundos = segundos;
        this.calidad = calidad;
        this.tamaño = tamaño;
        this.ruta=ruta;
    }
    
    public static Cancion crear(String cancion, String nombreAlbum, int minutos, int segundos, int calidad, int tamaño,String ruta) {
        return new Cancion(cancion,nombreAlbum,minutos,segundos,calidad,tamaño,ruta);
    }
    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getCancion() {
        return cancion;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getCalidad() {
        return calidad;
    }

    public int getTamaño() {
        return tamaño;
    }

   
}

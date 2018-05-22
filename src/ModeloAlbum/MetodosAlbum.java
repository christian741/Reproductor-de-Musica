/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloAlbum;

import BaseDatos.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Familia Díaz Rendón
 */
public class MetodosAlbum {
    
    private static BaseDatos database = new BaseDatos();
    
    /**
     * Enviar Informacion base de datos
     * @param persona 
     */

    public static void crear (Albums album) {
        try {
            String query = "INSERT INTO album (nombreAlbum, Artista, Genero,imagenAlbum) VALUES (?, ?, ?, ?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, album.getNombre());
            sentenciaP.setString(2, album.getArtista());
            sentenciaP.setString(3, album.getGenero());
            sentenciaP.setString(4, album.getImagen());
            
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
      public static Albums buscar(String nombre) {
        try {
            String query = "SELECT * FROM album WHERE nombreAlbum = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, nombre);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Albums.crear(resultado.getString("nombreAlbum"), resultado.getString("Artista"), resultado.getString("Genero"),resultado.getString("imagen"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
     public static ArrayList<Albums> obtenerTodos() {
         
        ArrayList<Albums> albunes = new ArrayList<Albums>();

        try {
            String query = "SELECT * FROM album;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                albunes.add(Albums.crear(resultado.getString("nombreAlbum"), resultado.getString("Artista"),resultado.getString("Genero"),resultado.getString("imagenAlbum")));
            }

            sentenciaP.close();
            database.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return albunes;
    }
    
}

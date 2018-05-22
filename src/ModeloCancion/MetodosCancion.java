/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCancion;

import BaseDatos.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Familia Díaz Rendón
 */
public class MetodosCancion {
    private static BaseDatos database = new BaseDatos();
    
    /**
     * 
     * @param cancion 
     */

    public static void crear (Cancion cancion) {
        try {
            String query = "INSERT INTO canciones (cancion, nombreAlbum, minutos,segundos, calidad, tamaño,ruta) VALUES (?, ?, ?, ?, ?, ?,?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, cancion.getCancion());
            sentenciaP.setString(2, cancion.getNombreAlbum());
            sentenciaP.setInt(3, cancion.getMinutos());
            sentenciaP.setInt(4, cancion.getSegundos());
            sentenciaP.setInt(5, cancion.getCalidad());
            sentenciaP.setInt(6, cancion.getTamaño());
            sentenciaP.setString(7, cancion.getRuta());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
      public static Cancion buscar(String nombre) {
        try {
            String query = "SELECT * FROM canciones WHERE cancion = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, nombre);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Cancion.crear(resultado.getString("cancion"), resultado.getString("nombreAlbum"), resultado.getInt("minutos"),resultado.getInt("segundos"),resultado.getInt("calidad"), resultado.getInt("tamaño"),resultado.getString("ruta"));
                        }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public static ArrayList<Cancion> obtenerTodos() {
         
        ArrayList<Cancion> canciones= new ArrayList<Cancion>();

        try {
            String query = "SELECT * FROM canciones;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
               canciones.add(Cancion.crear(resultado.getString("cancion"), resultado.getString("nombreAlbum"),resultado.getInt("minutos"),resultado.getInt("segundos"),resultado.getInt("calidad"),resultado.getInt("tamaño"),resultado.getString("ruta")));
            }

            sentenciaP.close();
            database.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return canciones;
    }
}

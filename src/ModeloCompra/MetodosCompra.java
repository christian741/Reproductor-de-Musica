/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCompra;

import BaseDatos.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Familia Díaz Rendón
 */
public class MetodosCompra {
    
      private static BaseDatos database = new BaseDatos();
    
     public static void crear (Compra compriña) {
        try {
            String query = "INSERT INTO compras (id, documento, nombre,cancion, album) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, compriña.getId());
            sentenciaP.setInt(2, compriña.getDocumento());
            sentenciaP.setString(3, compriña.getNombre());
            sentenciaP.setString(4, compriña.getCancion());
            sentenciaP.setString(5, compriña.getAlbum());
            
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
      public static ArrayList<Compra> obtenerTodos() {
         
        ArrayList<Compra> canciones= new ArrayList<Compra>();

        try {
            String query = "SELECT * FROM compras;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
               canciones.add(Compra.crear(resultado.getInt("id"), resultado.getInt("documento"),resultado.getString("nombre"),resultado.getString("cancion"),resultado.getString("album")));
            }

            sentenciaP.close();
            database.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return canciones;
    }

    
}

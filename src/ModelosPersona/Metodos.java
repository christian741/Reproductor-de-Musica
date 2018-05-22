package ModelosPersona;

import BaseDatos.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Metodos {
	
    private static BaseDatos database = new BaseDatos();
    
    /**
     * Enviar Informacion base de datos
     * @param persona 
     */

    public static void crear (Personas persona) {
        try {
            String query = "INSERT INTO usuarios (documento, nombre, apellido,password, telefono, email,foto) VALUES (?, ?, ?, ?, ?, ?,?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, persona.getDocumento());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setString(4, persona.getPassword());
            sentenciaP.setInt(5, persona.getTelefono());
            sentenciaP.setString(6, persona.getEmail());
             sentenciaP.setString(7, persona.getFoto());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

   /* public static void editar (Personas persona) {
        try {
            String query = "UPDATE usuarios SET documento = ?, nombre = ?,apellido=?, telefono = ?, email = ?, foto = ? WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, persona.getDocumento());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(2, persona.getApellido());
            sentenciaP.setInt(3, persona.getTelefono());
            sentenciaP.setString(4, persona.getEmail());
            sentenciaP.setString(5, persona.getFoto());
            sentenciaP.setString(6, Integer.toString(persona.getId()));

            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminar (Persona persona) {
        try {
            String query = "DELETE FROM usuarios WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getId()));

            sentenciaP.execute();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Persona obtener(int id) {
        try {
            String query = "SELECT * FROM usuarios WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(id));

            ResultSet resultado = sentenciaP.executeQuery();

            sentenciaP.close();
            database.close();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getString("documento"), resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("password"), resultado.getString("telefono"), resultado.getString("email"), resultado.getString("foto"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM usuarios WHERE documento = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getString("documento"), resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("password"), resultado.getString("telefono"), resultado.getString("email"), resultado.getString("foto"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }*/

    public static ArrayList<Personas> obtenerTodos() {
        ArrayList<Personas> personas = new ArrayList<Personas>();

        try {
            String query = "SELECT * FROM usuarios;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                personas.add(Personas.crear(resultado.getInt("documento"), resultado.getString("nombre"), resultado.getString("apellido"),resultado.getString("password"),resultado.getInt("telefono"), resultado.getString("email"), resultado.getString("foto")));
            }

            sentenciaP.close();
            database.close();

            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personas;
    }
}
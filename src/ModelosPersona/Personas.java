/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosPersona;

/**
 *
 * @author Familia Díaz Rendón
 */
public class Personas {
    /**
     * Declaracion Variables
     */
    private int documento , telefono ;   
    private String nombre,apellido,password,email,foto;
    /**
     * Constructor
     * @param documento
     * @param nombre
     * @param apellido
     * @param password
     * @param telefono
     * @param email
     * @param foto 
     */              
    public Personas(int documento, String nombre,String apellido,String password, int telefono, String email, String foto) {
   
        this.documento = documento;
        this.nombre = nombre;
        this.apellido=apellido;
        this.password=password;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
    }
    /**
     * Envia los paramateros del constructor a una BD
     * @param documento
     * @param nombre
     * @param apellido
     * @param password
     * @param telefono
     * @param email
     * @param foto
     * @return 
     */
    public static Personas crear(int documento, String nombre,String apellido,String password, int telefono, String email, String foto) {
        return new Personas(documento, nombre,apellido,password, telefono, email, foto);
    }
    /**
     * GETTER
     * @param documento
     * @param nombre
     * @param apellido
     * @param password
     * @param telefono
     * @param email
     * @param foto
     */
    public int getDocumento() {
        return documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFoto() {
        return foto;
    }
    /**
     * SETTER
     * @param documento
     * @param nombre
     * @param apellido
     * @param password
     * @param telefono
     * @param email
     * @param foto
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

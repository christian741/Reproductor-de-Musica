package BaseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    // JDBC driver URL
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private final String DB_URL = "jdbc:mysql://localhost:3306/reproductormusica?useSSL=false";
    
    //  Credenciales Base Datos
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Connection conn = null;
    
    public Connection open() {
        try {
            Class.forName(JDBC_DRIVER);
            try {
            	conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {
                
                System.out.println("No se pudo conectar a la base de datos"); 
            }
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Driver no encontrado"); 
        }
        return conn;
    }
    /**
     * Cerrar Base Datos
     */
    public void close(){
    	try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexi�n"); 
	}
    }
}


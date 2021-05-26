package persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/epp_items";
    private static final String USUARIO = "root";
    private static final String CLAVE="";
	public static Connection getConection() throws ClassNotFoundException, SQLException  {
		Connection conexion = null;
        Class.forName(CONTROLADOR);
        conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        System.out.println("Obtuvo acceso a su Base de Datos.");
        return conexion; 
	}
}
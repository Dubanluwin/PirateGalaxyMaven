package es.cursojava.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilidadesBD {
    private static final String URL_DB_ORACLE = "jdbc:oracle:thin:@10.2.1.10:1522:XE";
	private static final String USER_DB_ORACLE = "lordvik";
	private static final String PASSWORD_DB_ORACLE = "password";
    private static Connection connection = null;

    public static Connection crearConexion() {  // Conexión por defecto (DEFAULT).
        connection = crearConexion(URL_DB_ORACLE,USER_DB_ORACLE, PASSWORD_DB_ORACLE);
        return connection;
    }

    public static Connection crearConexion(String url_oracle, String username, String password) {
        // Connection connection = null;   // Declaramos el Connection fuera del try para poder devolverlo.
        try {   // No utilizamos el try-catch with resources porque eso implicaría el AutoCloseable.
            connection = DriverManager.getConnection(url_oracle, username, password);
        } catch (SQLException e) {
            System.err.println("Ha habido un error " + e.getMessage());
        } 
        return connection;
    }

    public static void cerrarConexion(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Ha habido un error " + e.getMessage());
        }
    }
}

package TiendaVideojuegos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:oracle://localhost:3306/BIBLIOTECA";
    private static final String USER = "AA";
    private static final String PASSWORD = "AA";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

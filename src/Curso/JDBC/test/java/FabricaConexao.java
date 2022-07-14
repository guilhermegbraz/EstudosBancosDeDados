package Curso.JDBC.test.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public Connection getConexao() throws SQLException {
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "20453");

        return con;
    }
}

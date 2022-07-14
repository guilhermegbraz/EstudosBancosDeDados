package Curso.JDBC.test.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexão {
    public static void main(String[] args) throws SQLException {
        Connection connection = new FabricaConexao().getConexao();

        connection.close();

    }
}

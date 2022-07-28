package Curso.JDBC.test.java;

import Curso.JDBC.main.java.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexão {
    public static void main(String[] args) throws SQLException {
        Connection connection = new FabricaConexao().getConexao();
        if (connection == null) {
            System.out.println("Nao conectou");
        }
        connection.close();

    }
}

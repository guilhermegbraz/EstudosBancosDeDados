package Curso.JDBC.test.java;

import Curso.JDBC.main.java.FabricaConexao;

import java.sql.SQLException;

public class TestaPoolConexoes {

    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();

        for(int i=0; i < 20; i++) {
            fabricaConexao.getConexao();
            System.out.println("conexão de numero:.. " + i);
        }
    }
}

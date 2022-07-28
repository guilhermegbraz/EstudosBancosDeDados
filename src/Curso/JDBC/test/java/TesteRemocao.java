package Curso.JDBC.test.java;

import Curso.JDBC.main.java.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteRemocao {

    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();

        Connection con = fabricaConexao.getConexao();

        PreparedStatement stm = con.prepareStatement("DELETE  FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        //Pegar a quantidade de linhas que foram modificadas
        Integer qtdLinhasModificadas = stm.getUpdateCount();

        System.out.println("Foram modificadas: " + qtdLinhasModificadas);
    }
}

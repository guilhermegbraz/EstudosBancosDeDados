package Curso.JDBC.test.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();

        Connection con = fabricaConexao.getConexao();

        Statement stm = con.createStatement();
        stm.execute("DELETE  FROM PRODUTO WHERE ID>2");

        //Pegar a quantidade de linhas que foram modificadas
        Integer qtdLinhasModificadas = stm.getUpdateCount();

        System.out.println("Foram modificadas: " + qtdLinhasModificadas);
    }
}

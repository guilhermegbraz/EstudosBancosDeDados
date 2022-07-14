package Curso.JDBC.test.java;

import java.sql.*;

public class TestaInsercao {

    public static void main(String[] args) {
        FabricaConexao fabricaConexao = new FabricaConexao();
        try(Connection con = fabricaConexao.getConexao()){

            Statement stm = con.createStatement();
            stm.execute(
                    "INSERT INTO PRODUTO (nome, descricao) " +
                            "VALUES ('Teclado', 'Teclado sem fio')"
            , Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stm .getGeneratedKeys();

            while (rs.next()) {
                Integer idCriado = rs.getInt(1);
                System.out.println("O id criado foi: " + idCriado);
            }


        }catch(SQLException ex){

        }
    }
}

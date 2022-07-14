package Curso.JDBC.test.java;

import java.sql.*;

public class TestaInserçãoComParametro {

    public static void main(String[] args) {
        String nome = "Mouse ' ";
        String descricao = "Mouse sem fio usb); delete from Produto;";

        FabricaConexao fabricaConexao = new FabricaConexao();

        try(Connection con = fabricaConexao.getConexao()){

            PreparedStatement pstm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao)  VALUES (?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, nome);
            pstm.setString(2, descricao);

            pstm.execute();

            ResultSet rs = pstm .getGeneratedKeys();

            while (rs.next()) {
                int idCriado = rs.getInt(1);
                System.out.println("O id criado foi: " + idCriado);
            }


        }catch(SQLException ex){

        }
    }
}

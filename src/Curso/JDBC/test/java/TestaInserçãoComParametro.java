package Curso.JDBC.test.java;

import Curso.JDBC.main.java.FabricaConexao;

import java.sql.*;

public class TestaInserçãoComParametro {

    public static void main(String[] args) {
        String nome = "Geladeira";
        String descricao = "Geladeira 3 portas); delete from Produto;";

        FabricaConexao fabricaConexao = new FabricaConexao();

        try(Connection con = fabricaConexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(
                    "INSERT INTO PRODUTO (nome, descricao)  VALUES (?, ?)"
                    , Statement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);

            try{
                adicionaVariavel(nome, descricao, pstm);

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                con.rollback();
            }

            con.commit();
        }catch(SQLException ex){

            throw new RuntimeException("Erro com o processo de criação de conexão " +
                    "ou no prepareStatement");

        }
    }

    public static void adicionaVariavel(String nome, String descricao, PreparedStatement pstm) throws SQLException {
        try {
            pstm.setString(1, nome);
            pstm.setString(2, descricao);
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()) {
                while (rs.next()) {
                    int idCriado = rs.getInt(1);
                    System.out.println("O id criado foi: " + idCriado);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("não foi possível adicionar o produto: " + nome);
        }
    }
}

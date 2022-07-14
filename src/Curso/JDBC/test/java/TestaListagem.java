package Curso.JDBC.test.java;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TestaListagem {

    public static void main(String[] args)   {

        try(Connection con = new FabricaConexao().getConexao()){

            Statement stm = con.createStatement();
            boolean resultado = stm.execute("SELECT id, nome, descricao FROM PRODUTO");

            System.out.println(resultado);

            ResultSet rs = stm.getResultSet();

            //Confere se tem um próximo item (linha)
            while(rs.next()) {

                //Escolhendo o campo q vamo puxar pelo nome da coluna (case insensitive)
               Integer id = rs.getInt("ID");

               //Acessando coluna pelo indice (a contagem das colunas não começa em 0)
               String nomeProduto = rs.getString(2);

               String descricao = rs.getString(3);

                System.out.println(id + " " + nomeProduto + " " + descricao);
            }


        }catch (SQLException ex){
            throw new RuntimeException("Falha na conexão com o banco de dados");
        }



    }
}

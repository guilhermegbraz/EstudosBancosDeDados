package Curso.JDBC.main.java;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String urlConexao = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String senha = "20453";

    public DataSource dataSource;

    public FabricaConexao() {
        //C3p0 é uma libary que implementa o pool de conexões para o MySQL
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(FabricaConexao.urlConexao);
        comboPooledDataSource.setUser(FabricaConexao.usuario);
        comboPooledDataSource.setPassword(FabricaConexao.senha );

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection getConexao() throws SQLException {

        return this.dataSource.getConnection();
    }
}

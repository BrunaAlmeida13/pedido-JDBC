package br.edu.infnet.pedido;

import br.edu.infnet.pedido.model.JdbcUtil;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcUtil.obterConexao();
        System.out.println("Hello!");
    }
}

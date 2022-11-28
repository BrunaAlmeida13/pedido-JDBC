package br.edu.infnet.pedido.model;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class JdbcUtilTest {

    @Test
    public void testConexao() {
        try (Connection obterConexao = JdbcUtil.obterConexao()) {
            Assert.assertTrue("Conectado", true);
        } catch (SQLException e) {
            fail();
        }
    }
}
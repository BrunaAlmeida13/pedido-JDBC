package br.edu.infnet.pedido;

import java.sql.SQLException;

import br.edu.infnet.pedido.model.JdbcUtil;
import br.edu.infnet.pedido.model.entidade.CarteiraEnum;
import br.edu.infnet.pedido.model.entidade.Entregador;
import br.edu.infnet.pedido.model.entidade.TipoVeiculoEnum;
import br.edu.infnet.pedido.model.persistencia.EntregadorDAO;
import br.edu.infnet.pedido.model.persistencia.IDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
    	JdbcUtil.obterConexao();
		System.out.println( "Hello!" );
    }
}

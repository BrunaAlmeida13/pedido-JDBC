package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.util.List;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Entregador;

public class EntregadorDAO extends JdbcDAO<Entregador> {

	public EntregadorDAO() {
	}
	
	@Override
	public Boolean salvar(Entregador entregador) {
		String sql = "insert into entregador(nome, tipoVeiculo, carteira) "
				+ "values (?, ?, ?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, entregador.getNome());
			pstm.setString(2, entregador.getTipoVeiculo().toString());
			pstm.setString(3, entregador.getCarteira().toString());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean atualizar(Entregador entregador) {
		String sql = "update entregador set nome = ?, tipoVeiculo = ?, carteira = ? where codigo = ?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, entregador.getNome());
			pstm.setString(2, entregador.getTipoVeiculo().toString());
			pstm.setString(3, entregador.getCarteira().toString());
			pstm.setLong(1, entregador.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deletar(Entregador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obter(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entregador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

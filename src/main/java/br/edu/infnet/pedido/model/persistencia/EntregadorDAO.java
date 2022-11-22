package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
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
        return false;
    }

    @Override
    public Boolean atualizar(Entregador entregador) {
        String sql = "update entregador set nome = ?, tipoVeiculo = ?, carteira = ? where codigo = ?";

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, entregador.getNome());
            pstm.setString(2, entregador.getTipoVeiculo().toString());
            pstm.setString(3, entregador.getCarteira().toString());
            pstm.setLong(4, entregador.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Entregador entregador) {
        String sql = "delete from entregador where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, entregador.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cliente obter(Long codigo) {
        // TODO Auto-generated method stub
        return null;
    }

    public Entregador obterEntregador(Long codigo) {
        String sql = "select * from entregador where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            Entregador entregador = null;
            if (rs.next()) {
                String nome = rs.getString("nome");
                Long codigoDB = rs.getLong("codigo");
                entregador = new Entregador(nome, codigoDB);
            }
            return entregador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Entregador> listarTodos() {
        String sql = "select * from entregador";
        List<Entregador> entregadores = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String nome = rs.getString("nome");
                Long codigo = rs.getLong("codigo");
                Entregador entregador = new Entregador(nome, codigo);
                entregadores.add(entregador);
            }
            return entregadores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

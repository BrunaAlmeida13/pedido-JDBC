package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Entrega;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class EntregaDAO extends JdbcDAO<Entrega> {

    @Override
    public Boolean salvar(Entrega entrega) {
        try{
            pstm = con.prepareStatement("insert into entrega(data_hora_inicio, status, endereco," +
                    " cd_cliente, cd_entregador) values(?, ?, ?, ?, ?)");

            pstm.setTimestamp(1, Timestamp.valueOf(entrega.getDataHoraEntregaInicio()));
            pstm.setString(2, entrega.getStatus().toString());
            pstm.setString(3, entrega.getEndereco());
            pstm.setLong(4, entrega.getCliente().getCodigo());

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean atualizar(Entrega obj) {
        return null;
    }

    @Override
    public Boolean deletar(Entrega obj) {
        return null;
    }

    @Override
    public Cliente obter(Long codigo) {
        return null;
    }

    @Override
    public List<Entrega> listarTodos() {
        return null;
    }
}

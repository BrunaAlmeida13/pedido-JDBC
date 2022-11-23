package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.*;
import br.edu.infnet.pedido.model.entidade.enums.StatusEnum;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            pstm.setInt(5, entrega.getEntregador().getCodigo());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean atualizar(Entrega entrega) {
        try{
            pstm = con.prepareStatement("update entrega set data_hora_inicio = ?, data_hora_fim = ?, status = ?, endereco = ?, cd_cliente = ?, cd_entregador = ?" +
                    "where cd_entrega = ?");

            pstm.setTimestamp(1, Timestamp.valueOf(entrega.getDataHoraEntregaInicio()));
            pstm.setTimestamp(2, Timestamp.valueOf(entrega.getDataHoraEntregaFim()));
            pstm.setString(3, entrega.getStatus().toString());
            pstm.setString(4, entrega.getEndereco());
            pstm.setLong(5, entrega.getCliente().getCodigo());
            pstm.setInt(6, entrega.getEntregador().getCodigo());
            pstm.setLong(7, entrega.getCodigo());

            return pstm.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Entrega entrega) {
        try{
            pstm = con.prepareStatement("delete from entrega where cd_entrega = ?");

            pstm.setLong(1, entrega.getCodigo());

            return pstm.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Entrega obter(Long codigo) {
        try{
            String sql = "select a.cd_entrega, " +
                         "a.data_hora_inicio, a.data_hora_fim, a.status, a.endereco, " +
                         "a.cd_cliente, a.cd_entregador, b.credencial, b.nome, " +
                         "b.tipoVeiculo, b.carteira, c.cliente, c.nome " +
                         "from entrega a " +
                         "inner join entregador b on a.cd_entregador = b.codigo " +
                         "inner join cliente c on a.cd_cliente = c.cliente" +
                         "where cd_entrega = ?";

            pstm = con.prepareStatement(sql);

            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()){
                TipoVeiculoEnum tipoVeiculoEnum = TipoVeiculoEnum.valueOf(rs.getString("b.tipoVeiculo"));
                CarteiraEnum carteiraEnum = CarteiraEnum.valueOf(rs.getString("b.carteira"));
                StatusEnum statusEnum = StatusEnum.valueOf(rs.getString("a.status"));
                LocalDateTime dthrInicio = rs.getTimestamp("a.data_hora_inicio").toLocalDateTime();
                LocalDateTime dthrFim = rs.getTimestamp("a.data_hora_fim").toLocalDateTime();

                Cliente objCliente = new Cliente(rs.getString("c.nome"), rs.getLong("c.codigo"));

                Entregador objEntregador = new Entregador(rs.getInt("b.credencial"),rs.getString("b.nome"),
                                            tipoVeiculoEnum, carteiraEnum);

                Entrega objEntrega = new Entrega(rs.getLong("a.cd_entrega"), dthrInicio, dthrFim, statusEnum,
                                    objCliente, rs.getString("a.endereco"), objEntregador);
                return  objEntrega;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Entrega> listarTodos() {
        return null;
    }
}

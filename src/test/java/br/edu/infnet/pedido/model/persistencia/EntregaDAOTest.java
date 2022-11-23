package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.*;
import br.edu.infnet.pedido.model.entidade.enums.StatusEnum;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class EntregaDAOTest {

    @Test
    public void test(){
        IDAO entregaDAO = new EntregaDAO();

        Cliente cliente = new Cliente("Jose das Couves", 1L);

        Entregador entregador = new Entregador(1,"Daniel", TipoVeiculoEnum.CARRO, CarteiraEnum.A);

        Entrega entrega = new Entrega(null, LocalDateTime.now(), null, StatusEnum.EM_PROGRESSO,
                                      cliente, "Sobradinho I - Quadra 6, Conjunto 12, Casa 02", entregador);


        Assert.assertTrue(entregaDAO.salvar(entrega));
    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testObterEntrega(){

    }

    @Test
    public void testListarEntregas(){

    }
}

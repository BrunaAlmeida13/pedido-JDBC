package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.*;
import br.edu.infnet.pedido.model.entidade.enums.CarteiraEnum;
import br.edu.infnet.pedido.model.entidade.enums.StatusEnum;
import br.edu.infnet.pedido.model.entidade.enums.TipoVeiculoEnum;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

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
        IDAO entregaDAO = new EntregaDAO();


        Cliente cliente = new Cliente("Jose das Couves", 1L);

        Entregador entregador = new Entregador(1,"Daniel", TipoVeiculoEnum.CARRO, CarteiraEnum.A);

        Entrega entrega = new Entrega(2L, LocalDateTime.now(), LocalDateTime.now().plusDays(5), StatusEnum.EM_PROGRESSO,
                cliente, "Ceilandia - QMS 33, Conjunto 12, Casa 13", entregador);

        Assert.assertTrue(entregaDAO.atualizar(entrega));
    }

    @Test
    public void testDelete(){
        IDAO entregaDAO = new EntregaDAO();


        Cliente cliente = new Cliente("Jose das Couves", 1L);

        Entregador entregador = new Entregador(1,"Daniel", TipoVeiculoEnum.CARRO, CarteiraEnum.A);

        Entrega entrega = new Entrega(2L, LocalDateTime.now(), LocalDateTime.now().plusDays(5), StatusEnum.EM_PROGRESSO,
                cliente, "Ceilandia - QMS 33, Conjunto 12, Casa 13", entregador);

        Assert.assertTrue(entregaDAO.deletar(entrega));
    }

    @Test
    public void testObterEntrega(){
        IDAO entregaDAO = new EntregaDAO();

        Entrega entrega = (Entrega) entregaDAO.obter(3L);

        System.out.println(entrega);

        Assert.assertNotNull(entrega);
    }

    @Test
    public void testListarEntregas(){
        IDAO entregaDAO = new EntregaDAO();

        List<Entrega> entregaList = entregaDAO.listarTodos();

        Assert.assertTrue(entregaList.size() > 0);
    }
}

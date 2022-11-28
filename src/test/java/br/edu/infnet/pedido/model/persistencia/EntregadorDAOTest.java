package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.CarteiraEnum;
import br.edu.infnet.pedido.model.entidade.Entregador;
import br.edu.infnet.pedido.model.entidade.TipoVeiculoEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EntregadorDAOTest {

    private IDAO entregadorDAO;

    @Before
    public void inicializar() {
        entregadorDAO = new EntregadorDAO();
        Entregador entregador = new Entregador("Daniel", TipoVeiculoEnum.CARRO, CarteiraEnum.A);
        entregadorDAO.salvar(entregador);
    }

    @Test
    public void test() {
        Entregador entregador = new Entregador("George", TipoVeiculoEnum.CARRO, CarteiraEnum.A);
        boolean validacao = entregadorDAO.salvar(entregador);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testeUpdate() {
        Entregador entregador = new Entregador(10L, "Nina", TipoVeiculoEnum.MOTO, CarteiraEnum.A);
        boolean validacao = entregadorDAO.atualizar(entregador);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testeDelete() {
        Entregador entregador = new Entregador(18L);
        boolean validacao = entregadorDAO.deletar(entregador);
        Assert.assertTrue(validacao);
    }

    @Test
    public void TesteObterEntregador() {
        EntregadorDAO entregadorDao = new EntregadorDAO();
        Entregador entregador = new Entregador(5L);
        Entregador entregadorResultado = entregadorDao.obterEntregador(entregador.getCodigo());
        Assert.assertNotNull(entregadorResultado);
    }

    @Test
    public void testeListaEntregadores() {
        List<Entregador> entregadores = entregadorDAO.listarTodos();
        Assert.assertTrue(entregadores.size() > 0);
    }
}
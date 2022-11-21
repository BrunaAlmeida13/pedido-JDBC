package br.edu.infnet.pedido.model.persistencia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedido.model.entidade.CarteiraEnum;
import br.edu.infnet.pedido.model.entidade.Entregador;
import br.edu.infnet.pedido.model.entidade.TipoVeiculoEnum;

public class EntregadorDAOTest {
	
	
	@Before
	public void inicializar() {
		IDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = new Entregador("Daniel", TipoVeiculoEnum.CARRO, CarteiraEnum.A);
		entregadorDAO.salvar(entregador);
	}
	
	@Test
	public void test() {
		IDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = new Entregador("George", TipoVeiculoEnum.CARRO, CarteiraEnum.A); 
		boolean validacao = entregadorDAO.salvar(entregador);
		Assert.assertTrue(validacao);
	}
	
/*	@Test
	public void testUpdate() {
		//IDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = new Entregador(1, "Damon", TipoVeiculoEnum.VAN, CarteiraEnum.C); 
		boolean validacao = entregadorDAO.atualizar(entregador);
		Assert.assertTrue(validacao);
	}*/

}

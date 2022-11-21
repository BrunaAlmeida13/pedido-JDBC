package br.edu.infnet.pedido.model.entidade;

public class Entregador {

	private int codigo;
	private String nome;
	private TipoVeiculoEnum tipoVeiculo;
	private CarteiraEnum carteira;
	// private Entrega entrega;

	public Entregador() {

	}

	public Entregador(String nome, TipoVeiculoEnum tipoVeiculo, CarteiraEnum carteira) {
		this.nome = nome;
		this.tipoVeiculo = tipoVeiculo;
		this.carteira = carteira;
	}
	
	public Entregador(int codigo, String nome, TipoVeiculoEnum tipoVeiculo, CarteiraEnum carteira) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipoVeiculo = tipoVeiculo;
		this.carteira = carteira;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public TipoVeiculoEnum getTipoVeiculo() {
		return tipoVeiculo;
	}

	public CarteiraEnum getCarteira() {
		return carteira;
	}

}

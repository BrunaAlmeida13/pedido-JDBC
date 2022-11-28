package br.edu.infnet.pedido.model.entidade;

public class Entregador {

    private Long codigo;
    private String nome;
    private TipoVeiculoEnum tipoVeiculo;
    private CarteiraEnum carteira;

    public Entregador() {

    }

    public Entregador(Long codigo) {
        this.codigo = codigo;
    }

    public Entregador(String nome, Long codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Entregador(String nome, TipoVeiculoEnum tipoVeiculo, CarteiraEnum carteira) {
        this.nome = nome;
        this.tipoVeiculo = tipoVeiculo;
        this.carteira = carteira;
    }

    public Entregador(Long codigo, String nome, TipoVeiculoEnum tipoVeiculo, CarteiraEnum carteira) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoVeiculo = tipoVeiculo;
        this.carteira = carteira;
    }

    public Long getCodigo() {
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
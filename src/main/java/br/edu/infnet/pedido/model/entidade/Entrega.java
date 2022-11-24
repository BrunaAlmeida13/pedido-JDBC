package br.edu.infnet.pedido.model.entidade;

import br.edu.infnet.pedido.model.entidade.enums.StatusEnum;

import java.time.LocalDateTime;

public class Entrega {
     private Long codigo;
     private LocalDateTime dataHoraEntregaInicio;

     private LocalDateTime dataHoraEntregaFim;
     private StatusEnum status;
     private String endereco;
     private Cliente cliente;
     private Entregador entregador;

     public Entrega(Long codigo, LocalDateTime dataHoraEntregaInicio, LocalDateTime dataHoraEntregaFim, StatusEnum status, Cliente cliente, String endereco, Entregador entregador) {
          this.codigo = codigo;
          this.dataHoraEntregaInicio = dataHoraEntregaInicio;
          this.dataHoraEntregaFim = dataHoraEntregaFim;
          this.status = status;
          this.cliente = cliente;
          this.endereco = endereco;
          this.entregador = entregador;
     }

     public Entregador getEntregador() {
          return entregador;
     }

     public void setEntregador(Entregador entregador) {
          this.entregador = entregador;
     }

     public LocalDateTime getDataHoraEntregaFim() {
          return dataHoraEntregaFim;
     }

     public void setDataHoraEntregaFim(LocalDateTime dataHoraEntregaFim) {
          this.dataHoraEntregaFim = dataHoraEntregaFim;
     }

     public Long getCodigo() {
          return codigo;
     }

     public void setCodigo(Long codigo) {
          this.codigo = codigo;
     }

     public String getEndereco() {
          return endereco;
     }

     public void setEndereco(String endereco) {
          this.endereco = endereco;
     }

     public LocalDateTime getDataHoraEntregaInicio() {
          return dataHoraEntregaInicio;
     }

     public void setDataHoraEntregaInicio(LocalDateTime dataHoraEntregaInicio) {
          this.dataHoraEntregaInicio = dataHoraEntregaInicio;
     }

     public StatusEnum getStatus() {
          return status;
     }

     public Cliente getCliente() {
          return cliente;
     }

     public void setCliente(Cliente cliente) {
          this.cliente = cliente;
     }

     @Override
     public String toString() {
          return "Entrega [codigo=" + codigo + ", Data/Hora Início =" + dataHoraEntregaInicio + ", Data/Hora Fim = "+ dataHoraEntregaFim + "" +
                  ", Status = "+status+", Cliente = "+ cliente + ", Entregador = " +entregador+"]";
     }
}

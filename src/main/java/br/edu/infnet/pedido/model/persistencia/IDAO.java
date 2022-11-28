package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;

import java.util.List;

public interface IDAO<T> {

    Boolean salvar(T obj);

    Boolean atualizar(T obj);

    Boolean deletar(T obj);

    Cliente obter(Long codigo);

    List<T> listarTodos();

}
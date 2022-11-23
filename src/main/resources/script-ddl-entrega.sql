create table entrega(
    cd_entrega int not null primary key auto_incriment,
    data_hora_inicio timestamp null,
    data_hora_fim timestamp null,
    status varchar(13),
    endereco varchar(200),
    cd_cliente int not null,
    cd_entregador int not null,
    foreign key (cd_cliente) references cliente(codigo)
    foreign key (cd_entregador) references entregador(codigo)
);

select
       a.data_hora_inicio, a.data_hora_fim, a.status, a.endereco,
       a.cd_cliente, a.cd_entregador, b.credencial, b.nome,
       b.tipoVeiculo, b.carteira, c.cliente, c.nome
from entrega a
inner join entregador b on a.cd_entregador = b.codigo
inner join cliente c on a.cd_cliente = c.cliente;
where cd_entrega = ?;
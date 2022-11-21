create table entrega(
    cd_entrega int not null primary key auto_incriment,
    data_hora_inicio timestamp,
    data_hora_fim timestamp,
    status varchar(13),
    endereco varchar(200),
    cd_cliente int not null,
    cd_entregador int not null,
    foreign key (cd_cliente) references cliente(codigo)
    foreign key (cd_entregador) references entregador(codigo)
);
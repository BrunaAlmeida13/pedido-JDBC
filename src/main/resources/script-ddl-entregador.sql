create database pedido;

use pedido;

create table entregador (
	codigo int not null primary key auto_increment,
	nome varchar(50),
	tipoVeiculo varchar(20),
	carteira varchar(1)
);

select * from entregador;

insert into entregador (credencial, nome, tipoVeiculo, carteira) values ('EMP123', 'Matheus', 'bicicleta','nenhuma');
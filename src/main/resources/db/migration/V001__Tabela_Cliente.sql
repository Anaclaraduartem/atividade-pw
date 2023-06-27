Create Table cliente(
id int not null auto_increment primary key,
nomecliente varchar (100)
);

insert into cliente(nomecliente, id) values ('Ana Clara', 1);
insert into cliente(nomecliente, id) values ('Bárbara', 2);
insert into cliente(nomecliente, id) values ('Nara Liggia', 3);
insert into cliente(nomecliente, id) values ('Érica', 4);

Create Table contaspagar(
    id int not null primary key auto_increment,
    data date,
    datavencimento date,
    valor decimal(16,2),
    idcliente int not null

);

Alter table contaspagar add constraint FK_ContasApagar_cliente foreign key (idcliente) REFERENCES cliente(id);

insert into contaspagar(data, datavencimento, valor, idcliente) values ('2023/04/01', '2023/05/01', 150, 1);
insert into contaspagar(data, datavencimento, valor, idcliente) values ('2023/03/08', '2023/04/08', 100, 2);
insert into contaspagar(data, datavencimento, valor, idcliente) values ('2023/01/05', '2023/02/05', 200, 3);
insert into contaspagar(data, datavencimento, valor, idcliente) values ('2023/04/13', '2023/05/13', 250, 4);

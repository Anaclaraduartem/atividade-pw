create table cliente(

idcliente int not null primary key auto_increment,
nome varchar (100)

);

insert into cliente (nome) values ('Ana Clara');
insert into cliente (nome) values ('Barbára');
insert into cliente (nome) values ('Ariane');
insert into cliente (nome) values ('Nara');


create table Contaspagar(
id int not null primary key auto_increment,
data date,
datavencimento date,
valor decimal(16,2),
idcliente int not null
);

Alter table Contaspagar add constraint FK_Contaspagar_cliente foreign key (idcliente) REFERENCES cliente(idcliente);

insert into Contaspagar(data, datavencimento, valor, idcliente) values  ('2023/1/10', '2023/1/12', 200, 1);
insert into Contaspagar(data, datavencimento, valor, idcliente) values  ('2023/2/5', '2023/5/5', 1500, 2);
insert into Contaspagar(data, datavencimento, valor, idcliente) values  ('2023/2/15', '2023/2/28', 2500, 3);
insert into Contaspagar(data, datavencimento, valor, idcliente) values  ('2023/4/10', '2023/4/25', 200, 4);



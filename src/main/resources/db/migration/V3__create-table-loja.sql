create table loja(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cnpj bigint(14) not null unique,

    primary key(id)

);
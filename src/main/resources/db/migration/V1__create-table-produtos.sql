create table produtos(

    id bigint not null autoincrement,
    nome varchar(100) not null,
    min_producao varchar(10) not null,
    qtd_embalado varchar(10) not null,
    dia_producao varchar(100) not null,

    primary key(id)

);
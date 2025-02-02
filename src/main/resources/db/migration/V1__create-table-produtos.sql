create table produto(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    min_producao bigint(10) not null,
    qtd_embalado bigint(10) not null,
    dia_producao ENUM('DOMINGO','SEGUNDA','TERCA','QUARTA','QUINTA','SEXTA','SABADO','DIARIO') not null,

    primary key(id)

);
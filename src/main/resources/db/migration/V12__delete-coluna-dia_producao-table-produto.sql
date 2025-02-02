create table dia_producao(

    id bigint not null auto_increment,
    id_produto bigint not null,
    dia_producao ENUM('DOMINGO','SEGUNDA','TERCA','QUARTA','QUINTA','SEXTA','SABADO') not null,

    primary key(id),
    constraint fk_dia_producao_id_produto foreign key(id_produto) references produto(id)

);